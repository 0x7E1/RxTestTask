package com.onseo.testtask.facade;

import com.onseo.testtask.domain.dto.Album;
import com.onseo.testtask.domain.dto.Comment;
import com.onseo.testtask.domain.dto.Photo;
import com.onseo.testtask.domain.dto.Post;
import com.onseo.testtask.domain.dto.ResultObject;
import com.onseo.testtask.domain.dto.ToDo;
import com.onseo.testtask.service.DataLoader;
import com.onseo.testtask.service.TestDataLoaderImpl;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ApplicationRunnerFacade {

    private final DataLoader dataLoader;

    public ApplicationRunnerFacade() {
        this.dataLoader = new TestDataLoaderImpl();
    }

    public ResultObject getResult() {
        Post post = dataLoader.loadPost();
        Comment comment = dataLoader.loadComment(post.getId());
        Album album = dataLoader.loadAlbum();
        Photo photo = dataLoader.loadPhoto(album.getId());
        Long userId = album.getUserId(); //or from post.getUserId(). they must be same
        ToDo toDo = dataLoader.loadToDo(userId);
        return dataLoader.createResultObject(userId, post, comment, album, toDo, photo);
    }

    public CompletableFuture<ResultObject> getResultAsync() {
        CompletableFuture<Post> postFuture = CompletableFuture.supplyAsync(dataLoader::loadPost);
        CompletableFuture<Comment> commentFuture = postFuture.thenApplyAsync(result -> dataLoader.loadComment(result.getId()));
        CompletableFuture<Album> albumFuture = CompletableFuture.supplyAsync(dataLoader::loadAlbum);
        CompletableFuture<Photo> photoFuture = albumFuture.thenApplyAsync(result -> dataLoader.loadPhoto(result.getId()));
        CompletableFuture<Long> userIdFuture =
                CompletableFuture.anyOf(albumFuture.thenApply(Album::getUserId), postFuture.thenApply(Post::getUserId))
                        .thenApply(id -> (Long) id);
        CompletableFuture<ToDo> toDoFuture = userIdFuture.thenApplyAsync(dataLoader::loadToDo);

        return CompletableFuture.supplyAsync(() -> {
            try {
                return dataLoader.createResultObject(
                        userIdFuture.get(),
                        postFuture.get(),
                        commentFuture.get(),
                        albumFuture.get(),
                        toDoFuture.get(),
                        photoFuture.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public Observable<ResultObject> getResultObservable() {
        //TODO implement Observable solution

        return Observable.fromCallable(() -> {
            Post post = dataLoader.loadPost();
            Album album = dataLoader.loadAlbum();
            ToDo toDo = dataLoader.loadToDo(post.getUserId());
            Comment comment = dataLoader.loadComment(post.getId());
            Photo photo = dataLoader.loadPhoto(album.getId());
            return dataLoader.createResultObject(post.getUserId(), post, comment, album, toDo, photo);
        });
    }
}
