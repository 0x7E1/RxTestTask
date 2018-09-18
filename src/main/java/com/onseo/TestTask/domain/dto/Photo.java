package com.onseo.TestTask.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private Long albumId;
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
