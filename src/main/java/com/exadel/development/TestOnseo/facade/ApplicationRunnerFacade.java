package com.exadel.development.TestOnseo.facade;

import com.exadel.development.TestOnseo.domain.dto.*;
import com.exadel.development.TestOnseo.service.DataLoader;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class ApplicationRunnerFacade {

    private DataLoader dataLoader;

    public ApplicationRunnerFacade() {
        this.dataLoader = new DataLoader();
    }

    public ResultObject getResult() throws ExecutionException, InterruptedException {
        CompletableFuture<Post> postFuture = dataLoader.loadPost();
        Post post = postFuture.get();
        CompletableFuture<Comment> commentFuture = dataLoader.loadComment(post.getId());
        CompletableFuture<Object> albumFuture = dataLoader.loadAlbum();
        CompletableFuture<ToDo> toDoFuture = dataLoader.loadToDo();
        CompletableFuture<Photo> photoFuture = dataLoader.loadPhoto();

        Comment comment = commentFuture.get();
        Album album = (Album) albumFuture.get();
        ToDo toDo = toDoFuture.get();
        Photo photo = photoFuture.get();

        log.info("All objects are loaded!");
        return new ResultObject(1L, post, comment, album, toDo, photo);
    }
}
