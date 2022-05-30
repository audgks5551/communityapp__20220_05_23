package com.example.backend.article.entity;

import com.example.backend.article.repository.ArticleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ArticleEntityTest {
    @Autowired
    ArticleRepository articleRepository;

    Article article;
    String userId;
    String articleId;
    @BeforeEach
    public void init() {
        userId = UUID.randomUUID().toString();
        article = new Article();
        article.setTitle("title");
        article.setBody("content");
        article.setArticleId(articleId);
        article.setUserId(userId);
    }

    @AfterEach
    public void finish() {
        articleRepository.deleteAll();
    }

    @Test
    public void 게시글_생성() {

        Article savedArticle = articleRepository.save(article);

        assertThat(savedArticle).isSameAs(article); // 같은 객체 확인
        assertThat(savedArticle.getUserId().toString()).isEqualTo(userId.toString()); // uuid 같은지 확인
        assertThat(savedArticle.getId()).isNotNull(); // id null 확인
        assertThat(savedArticle.getCreatedDate()).isNotNull(); // created null 확인
        assertThat(savedArticle.getModifiedDate()).isNotNull(); // modified null 확인
    }

    @Test
    public void title_길이_확인() {
        article.setTitle(getTitle());

        assertThatThrownBy(() -> articleRepository.save(article))
                .isInstanceOf(InvalidDataAccessResourceUsageException.class);
    }

    private String getTitle() {
        String title = "";
        for (int i=0; i<51; i++) {
            title += "가";
        }
        return title;
    }
}
