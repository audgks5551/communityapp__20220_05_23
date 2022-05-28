package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.repository.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ArticleServiceTest {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleRepository articleRepository;

    ArticleDTO articleDTO;

    @BeforeEach
    public void start() {
        articleDTO = new ArticleDTO();
        articleDTO.setTitle("title");
        articleDTO.setBody("content");
        articleDTO.setUserId(UUID.randomUUID());
    }

    @AfterEach
    public void end() {
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글_생성 () {
        ArticleDTO savedArticleDTO = articleService.createArticle(articleDTO);

        assertThat(savedArticleDTO.getId()).isNotNull();
    }
}
