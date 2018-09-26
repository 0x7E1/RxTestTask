package com.onseo.testtask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class ResultObject {
    private final Long userId;
    private final Post post;
    private final Comment comment;
    private final Album album;
    private final ToDo toDo;
    private final Photo photo;
}