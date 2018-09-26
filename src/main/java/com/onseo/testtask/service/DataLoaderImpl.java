package com.onseo.testtask.service;

/*
public class DataLoaderImpl implements DataLoader {
    private static final String POSTS_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String COMMENTS_URL = "https://jsonplaceholder.typicode.com/comments";
    private static final String ALBUM_URL = "https://jsonplaceholder.typicode.com/albums";
    private static final String TODO_URL = "https://jsonplaceholder.typicode.com/todos";
    private static final String PHOTO_URL = "https://jsonplaceholder.typicode.com/photos";



    private HttpService httpService;
    private DataMapper mapper;

    public DataLoaderImpl() {
        this.httpService = new HttpService();
        this.mapper = new DataMapper();
    }

    @Override
    public Post loadPost() {
        String resultJson = httpService.doGet(POSTS_URL);
        return mapper.mapToObject(resultJson, Post[].class);
    }

    @Override
    public Comment loadComment(Long postId) {
        String url = COMMENTS_URL + "?postId=" + postId;
        String resultJson = httpService.doGet(url);
        return mapper.mapToObject(resultJson, Comment[].class);
    }

    @Override
    public ToDo loadToDo(Long userId) {
        String resultJson = httpService.doGet(TODO_URL);
        return mapper.mapToObject(resultJson, ToDo[].class);
    }

    @Override
    public Photo loadPhoto() {
        String resultJson = httpService.doGet(PHOTO_URL);
        return mapper.mapToObject(resultJson, Photo[].class);
    }

    @Override
    public Iterable<Album> loadAlbums() {
        Album album1 = loadAlbumById(15L);
        Album album2 = loadAlbumById(43L);
        Album album3 = loadAlbumById(31L);
        return Arrays.asList(album1, album2, album3);
    }

    @Override
    public Album loadAlbumById(Long id) {
        String resultJson = httpService.doGet(ALBUM_URL + "?id=" + id);
        return mapper.mapToObject(resultJson, Album[].class);
    }
}
*/
