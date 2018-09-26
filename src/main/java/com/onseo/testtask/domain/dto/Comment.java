package com.onseo.testtask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Comment {
    private final Long postId;
    private final Long id;
    private final String name;
    private final String email;
    private final String body;
}
