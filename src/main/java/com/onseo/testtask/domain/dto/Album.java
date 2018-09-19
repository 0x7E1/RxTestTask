package com.onseo.testtask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Album {
    private final Long userId;
    private final Long id;
    private final String title;
}
