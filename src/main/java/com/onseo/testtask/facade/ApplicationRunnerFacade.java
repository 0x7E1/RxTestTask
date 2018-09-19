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
        //TODO implement CompletableFuture solution
        return CompletableFuture.completedFuture(getResult());

//        CompletableFuture<Post> postFuture = dataLoader.loadPost();
//        Post post = postFuture.get();
//        CompletableFuture<Comment> commentFuture = dataLoader.loadComment(post.getId());
//        CompletableFuture<Object> albumFuture = dataLoader.loadAlbum();
//        CompletableFuture<ToDo> toDoFuture = dataLoader.loadToDo();
//        CompletableFuture<Photo> photoFuture = dataLoader.loadPhoto();
//
//        Comment comment = commentFuture.get();
//        Album album = (Album) albumFuture.get();
//        ToDo toDo = toDoFuture.get();
//        Photo photo = photoFuture.get();
//
//        log.info("All objects are loaded!");
//        return new ResultObject(1L, post, comment, album, toDo, photo);
    }

    public Observable<ResultObject> getResultObservable() {
        //TODO implement Observable solution
        return Observable.just(getResult());
    }
}
