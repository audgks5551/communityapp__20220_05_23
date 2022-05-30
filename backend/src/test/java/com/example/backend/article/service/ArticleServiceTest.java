package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.entity.Article;
import com.example.backend.article.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

/**
 * article service 단위테스트
 */
@ExtendWith(MockitoExtension.class)
public class ArticleServiceTest {
    @Mock
    private ArticleRepository articleRepository;

    @Spy
    private ModelMapper modelMapper;

    @InjectMocks
    private ArticleServiceImpl articleService;

    ArticleDTO articleDTO = new ArticleDTO();
    Article article = new Article();

    @BeforeEach
    public void init() {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);

        articleDTO.setTitle("title");
        articleDTO.setBody("content");
        articleDTO.setUserId(UUID.randomUUID().toString());

        article = modelMapper.map(articleDTO, Article.class);
    }

    @Test
    public void 게시글_생성 () {

        given(articleRepository.save(any())).willReturn(article);

        ArticleDTO savedArticleDTO = articleService.createArticle(articleDTO);

        assertThat(savedArticleDTO.getTitle()).isEqualTo(articleDTO.getTitle());
        assertThat(savedArticleDTO.getBody()).isEqualTo(articleDTO.getBody());
        assertThat(savedArticleDTO.getUserId()).isEqualTo(articleDTO.getUserId());
    }
}
