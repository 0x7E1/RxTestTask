package com.exadel.development.TestOnseo.service;

import com.exadel.development.TestOnseo.domain.dto.*;

public interface DataLoader {
    Post loadPost();

    Comment loadComment(Long postId);

    Album loadAlbum();

    ToDo loadToDo();

    Photo loadPhoto();
}
