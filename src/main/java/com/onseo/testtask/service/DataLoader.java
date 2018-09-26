package com.onseo.testtask.service;

import com.onseo.testtask.domain.dto.Album;
import com.onseo.testtask.domain.dto.Comment;
import com.onseo.testtask.domain.dto.Photo;
import com.onseo.testtask.domain.dto.Post;
import com.onseo.testtask.domain.dto.ResultObject;
import com.onseo.testtask.domain.dto.ToDo;

public interface DataLoader {
    Post loadPost();

    Comment loadComment(Long postId);

    ToDo loadToDo(Long userId);

    Photo loadPhoto(Long albumId);

    Album loadAlbum();

    ResultObject createResultObject(Long userId, Post post, Comment comment, Album album, ToDo toDo, Photo photo);
}
