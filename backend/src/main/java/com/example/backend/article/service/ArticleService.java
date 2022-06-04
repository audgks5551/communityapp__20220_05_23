package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;

import java.util.Optional;

public interface ArticleService {
    Optional<ArticleDTO> createArticle(ArticleDTO articleDTO);
}
