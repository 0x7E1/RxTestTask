package com.exadel.development.TestOnseo;

import com.exadel.development.TestOnseo.domain.ResultObject;
import com.exadel.development.TestOnseo.domain.dto.*;
import com.exadel.development.TestOnseo.service.DataLoader;
import com.exadel.development.TestOnseo.service.impl.DataLoaderImpl;

public class Application {
    
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        DataLoader loader = new DataLoaderImpl();

        Post post = loader.loadPost();
        Comment comment = loader.loadComment();
        Album album = loader.loadAlbum();
        ToDo toDo = loader.loadToDo();
        Photo photo = loader.loadPhoto();

        ResultObject resultObject = new ResultObject(post, comment, album, toDo, photo);

        System.out.println(resultObject);
    }
}
