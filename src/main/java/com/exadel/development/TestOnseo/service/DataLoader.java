package com.exadel.development.TestOnseo.service;

import com.exadel.development.TestOnseo.domain.dto.*;
import java.util.concurrent.CompletableFuture;

public class DataLoader {
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String ALBUM_URL = "https://jsonplaceholder.typicode.com/albums";
    private static final String TODO_URL = "https://jsonplaceholder.typicode.com/todos";
    private static final String PHOTO_URL = "https://jsonplaceholder.typicode.com/photos";

    private HttpService httpService;
    private DataMapper mapper;

    public DataLoader() {
        this.httpService = new HttpService();
        this.mapper = new DataMapper();
    }

    public CompletableFuture<Post> loadPost() {
        return CompletableFuture.supplyAsync(() -> {
            String resultJson = httpService.doGet(POSTS_URL);
            return mapper.mapToObject(resultJson, Post[].class);
        });
    }

    public CompletableFuture<Comment> loadComment(Long postId) {
        return CompletableFuture.supplyAsync(() -> {
            String url = COMMENTS_URL + "?postId=" + postId;
            String resultJson = httpService.doGet(url);
            return mapper.mapToObject(resultJson, Comment[].class);
        });
    }

    public CompletableFuture<Object> loadAlbum() {
        CompletableFuture<Album> albumFuture1 = loadAlbumById(15L);
        CompletableFuture<Album> albumFuture2 = loadAlbumById(43L);
        CompletableFuture<Album> albumFuture3 = loadAlbumById(31L);

        return CompletableFuture.anyOf(albumFuture1, albumFuture2, albumFuture3);
    }

    public CompletableFuture<ToDo> loadToDo() {
        return CompletableFuture.supplyAsync(() -> {
            String resultJson = httpService.doGet(TODO_URL);
            return mapper.mapToObject(resultJson, ToDo[].class);
        });
    }

    public CompletableFuture<Photo> loadPhoto() {
        return CompletableFuture.supplyAsync(() -> {
            String resultJson = httpService.doGet(PHOTO_URL);
            return mapper.mapToObject(resultJson, Photo[].class);
        });
    }

    private CompletableFuture<Album> loadAlbumById(Long id) {
        return CompletableFuture.supplyAsync(() -> {
            String resultJson = httpService.doGet(ALBUM_URL + "?id=" + id);
            return mapper.mapToObject(resultJson, Album[].class);
        });
    }
}
