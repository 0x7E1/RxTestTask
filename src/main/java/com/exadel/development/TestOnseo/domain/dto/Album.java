package com.exadel.development.TestOnseo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album {
    private Long userId;
    private Long id;
    private String title;
}
