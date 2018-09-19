package com.onseo.testtask.service;

import com.onseo.testtask.domain.dto.Album;
import com.onseo.testtask.domain.dto.Comment;
import com.onseo.testtask.domain.dto.Photo;
import com.onseo.testtask.domain.dto.Post;
import com.onseo.testtask.domain.dto.ResultObject;
import com.onseo.testtask.domain.dto.ToDo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestDataLoaderImpl implements DataLoader {
    private final static int DEFAULT_DELAY = 100;

    private final static int ALBUM_DELAY = DEFAULT_DELAY;
    private final static int COMMENT_DELAY = DEFAULT_DELAY;
    private final static int PHOTO_DELAY = DEFAULT_DELAY;
    private final static int POST_DELAY = DEFAULT_DELAY;
    private final static int TODO_DELAY = DEFAULT_DELAY;
    private final static int RESULT_DELAY = DEFAULT_DELAY;

    private final static Long userId = 12L;

    @Override
    public Post loadPost() {
        log.info("{} creation start...", Post.class.getSimpleName());
        try {
            Thread.sleep(POST_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Post post = new Post(userId, 3214L, "post_title", "post_body");
        log.info("{} creation finish = {}", Post.class.getSimpleName(), post);
        return post;
    }

    @Override
    public Comment loadComment(Long postId) {
        log.info("{} creation start...", Comment.class.getSimpleName());
        try {
            Thread.sleep(COMMENT_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Comment comment = new Comment(postId, 43L, "comment_name", "comment_email", "comment_body");
        log.info("{} creation finish = {}", Comment.class.getSimpleName(), comment);
        return comment;
    }

    @Override
    public ToDo loadToDo(Long userId) {
        log.info("{} creation start...", ToDo.class.getSimpleName());
        try {
            Thread.sleep(TODO_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ToDo todo = new ToDo(userId, 321L, "todo_title", true);
        log.info("{} creation finish = {}", ToDo.class.getSimpleName(), todo);
        return todo;
    }

    @Override
    public Photo loadPhoto(Long albumId) {
        log.info("{} creation start...", Photo.class.getSimpleName());
        try {
            Thread.sleep(PHOTO_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Photo photo = new Photo(albumId, 455L, "album_title", "album_url", "album_thumbnailUrl");
        log.info("{} creation finish = {}", Photo.class.getSimpleName(), photo);
        return photo;
    }

    @Override
    public Album loadAlbum() {
        log.info("{} creation start...", Album.class.getSimpleName());
        try {
            Thread.sleep(ALBUM_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Album album = new Album(userId, 213L, "album_title");
        log.info("{} creation finish = {}", Album.class.getSimpleName(), album);
        return album;
    }

    @Override
    public ResultObject createResultObject(Long userId, Post post, Comment comment, Album album, ToDo toDo, Photo photo) {
        log.info("{} creation start...", ResultObject.class.getSimpleName());
        try {
            Thread.sleep(RESULT_DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResultObject resultObject = new ResultObject(userId, post, comment, album, toDo, photo);
        log.info("{} creation finish = {}", ResultObject.class.getSimpleName(), resultObject);
        return resultObject;
    }
}
