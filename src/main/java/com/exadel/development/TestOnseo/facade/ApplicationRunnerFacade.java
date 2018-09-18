package com.exadel.development.TestOnseo.facade;

import com.exadel.development.TestOnseo.domain.dto.*;
import com.exadel.development.TestOnseo.service.DataLoader;

public class ApplicationRunnerFacade {

    private DataLoader dataLoader;

    public ApplicationRunnerFacade() {
        this.dataLoader = new DataLoader();
    }

    public ResultObject getResult() {
        Post post = dataLoader.loadPost();
        Comment comment = dataLoader.loadComment(post.getId());
        Album album = dataLoader.loadAlbum();
        ToDo toDo = dataLoader.loadToDo();
        Photo photo = dataLoader.loadPhoto();

        return new ResultObject(post, comment, album, toDo, photo);
    }
}
