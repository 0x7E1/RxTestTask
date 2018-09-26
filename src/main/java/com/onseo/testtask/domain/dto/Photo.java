package com.onseo.testtask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Photo {
    private final Long albumId;
    private final Long id;
    private final String title;
    private final String url;
    private final String thumbnailUrl;
}
