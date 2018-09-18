package com.exadel.development.TestOnseo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultObject {
    private Long id;
    private Post post;
    private Comment comment;
    private Album album;
    private ToDo toDo;
    private Photo photo;
}