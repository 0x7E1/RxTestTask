package com.onseo.testtask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Post {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
