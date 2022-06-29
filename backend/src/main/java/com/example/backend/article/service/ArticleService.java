package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    Optional<ArticleDTO> createArticle(ArticleDTO articleDTO);
    List<ArticleDTO> listArticlesByUserId(String userId);
    Optional<ArticleDTO> detailArticleByArticleId(String articleId);

    Boolean verifyArticlePermission(String userId, String articleId);
}
