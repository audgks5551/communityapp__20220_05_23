package com.example.backend.article.repository;

import com.example.backend.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ArticleRepository extends JpaRepository<Article, UUID> {
    List<Article> findArticlesByUserId(String userId);
    Optional<Article> findArticleByArticleId(String articleId);
    Boolean existsArticleByArticleIdAndUserId(String articleId, String userId);

    @Transactional
    void deleteByArticleId(String articleId);
}
