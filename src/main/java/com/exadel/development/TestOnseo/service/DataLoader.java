package com.exadel.development.TestOnseo.service;

import com.exadel.development.TestOnseo.domain.dto.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class DataLoader {
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String ALBUM_URL = "https://jsonplaceholder.typicode.com/albums";
    private static final String TODO_URL = "https://jsonplaceholder.typicode.com/todos";
    private static final String PHOTO_URL = "https://jsonplaceholder.typicode.com/photos";

    private HttpService httpService;

    private ObjectMapper mapper;

    public DataLoader() {
        this.httpService = new HttpService();
        this.mapper = new ObjectMapper();
    }

    public Post loadPost() {
        try {
            String resultJson = httpService.doGet(POSTS_URL);
            return mapper.readValue(resultJson, Post[].class)[0];
        } catch (IOException e) {
            return null;
        }
    }

    public Comment loadComment(Long postId) {
        try {
            String url = COMMENTS_URL + "?postId=" + postId;
            String resultJson = httpService.doGet(url);
            return mapper.readValue(resultJson, Comment[].class)[0];
        } catch (IOException e) {
            return null;
        }
    }

    public Album loadAlbum() {
        try {
            String resultJson = httpService.doGet(ALBUM_URL);
            return mapper.readValue(resultJson, Album[].class)[0];
        } catch (IOException e) {
            return null;
        }
    }

    public ToDo loadToDo() {
        try {
            String resultJson = httpService.doGet(TODO_URL);
            return mapper.readValue(resultJson, ToDo[].class)[0];
        } catch (IOException e) {
            return null;
        }
    }

    public Photo loadPhoto() {
        try {
            String resultJson = httpService.doGet(PHOTO_URL);
            return mapper.readValue(resultJson, Photo[].class)[0];
        } catch (IOException e) {
            return null;
        }
    }
}
