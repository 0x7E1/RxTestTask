package com.exadel.development.TestOnseo.domain;

import com.exadel.development.TestOnseo.domain.dto.*;

import java.util.Random;

public class ResultObject {
    private Long id;
    private Post post;
    private Comment comment;
    private Album album;
    private ToDo toDo;
    private Photo photo;

    public ResultObject() {
    }

    public ResultObject(Post post, Comment comment, Album album, ToDo toDo, Photo photo) {
        this.id = Math.abs(new Random().nextLong());
        this.post = post;
        this.comment = comment;
        this.album = album;
        this.toDo = toDo;
        this.photo = photo;
    }

    public Long getId() {
        return id;
    }

    public Post getPost() {
        return post;
    }

    public Comment getComment() {
        return comment;
    }

    public Album getAlbum() {
        return album;
    }

    public ToDo getToDo() {
        return toDo;
    }

    public Photo getPhoto() {
        return photo;
    }
}
