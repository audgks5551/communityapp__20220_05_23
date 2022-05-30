package com.example.backend.article.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDTO {
    private String id;
    private String articleId;
    private String title;
    private String body;
    private String userId;
}
