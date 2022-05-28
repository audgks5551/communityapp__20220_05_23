package com.example.backend.article.service;

import com.example.backend.article.dto.ArticleDTO;
import com.example.backend.article.entity.Article;
import com.example.backend.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ModelMapper mapper;
    private final ArticleRepository articleRepository;

    /**
     * article create service
     */
    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = mapper.map(articleDTO, Article.class);
        Article savedArticle = articleRepository.save(article);
        ArticleDTO savedArticleDTO = mapper.map(savedArticle, ArticleDTO.class);
        return savedArticleDTO;
    }
}
