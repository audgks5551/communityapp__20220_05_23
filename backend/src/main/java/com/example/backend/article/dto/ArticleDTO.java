package com.example.backend.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ArticleDTO {
    private UUID id;
    private String title;
    private String body;
    private UUID userId;
}
