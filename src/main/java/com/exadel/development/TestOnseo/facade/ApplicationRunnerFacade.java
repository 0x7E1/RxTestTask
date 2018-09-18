package com.exadel.development.TestOnseo.facade;

import com.exadel.development.TestOnseo.domain.dto.*;
import com.exadel.development.TestOnseo.service.DataLoader;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ApplicationRunnerFacade {

    private DataLoader dataLoader;

    public ApplicationRunnerFacade() {
        this.dataLoader = new DataLoader();
    }

    public ResultObject getResult() {
        CompletableFuture<Post> postFuture = dataLoader.loadPost();
        CompletableFuture<Comment> commentFuture = dataLoader.loadComment();
        CompletableFuture<Album> albumFuture = dataLoader.loadAlbum();
        CompletableFuture<ToDo> toDoFuture = dataLoader.loadToDo();
        CompletableFuture<Photo> photoFuture = dataLoader.loadPhoto();

        try {
            Post post = postFuture.get();
            Comment comment = commentFuture.get();
            Album album = albumFuture.get();
            ToDo toDo = toDoFuture.get();
            Photo photo = photoFuture.get();

            return new ResultObject(1L, post, comment, album, toDo, photo);
        } catch (InterruptedException | ExecutionException e) {
            return null;
        }
    }
}
