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

    public CompletableFuture<ResultObject> getResultAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Long> userIdFuture1 = CompletableFuture.supplyAsync(() -> dataLoader.loadPost().getUserId());
        CompletableFuture<Long> userIdFuture2 = CompletableFuture.supplyAsync(() -> dataLoader.loadAlbum().getUserId());
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(userIdFuture1, userIdFuture2);
        Long userId = (Long) anyOfFuture.get(); //race condition. getting userId from Post or Album

        CompletableFuture<Post> postFuture = CompletableFuture.supplyAsync(dataLoader::loadPost);
        CompletableFuture<Album> albumFuture = CompletableFuture.supplyAsync(dataLoader::loadAlbum);
        CompletableFuture<ToDo> toDoFuture = CompletableFuture.supplyAsync(() -> dataLoader.loadToDo(userId));
        CompletableFuture<Comment> commentFuture = postFuture.thenApply(result -> dataLoader.loadComment(result.getId())); //execute postFuture, then get post's ID and pass it as parameter to loadComment()
        CompletableFuture<Photo> photoFuture = albumFuture.thenApply(result -> dataLoader.loadPhoto(result.getId())); //the same for album's ID and loadPhoto()

        Post post = postFuture.get();
        Album album = albumFuture.get();
        ToDo toDo = toDoFuture.get();
        Comment comment = commentFuture.get();
        Photo photo = photoFuture.get();

        return CompletableFuture.supplyAsync(() -> dataLoader.createResultObject(userId, post, comment, album, toDo, photo));
    }

    public Observable<ResultObject> getResultObservable() {
        //TODO implement Observable solution
        return Observable.fromCallable(this::getResult);
    }
}
