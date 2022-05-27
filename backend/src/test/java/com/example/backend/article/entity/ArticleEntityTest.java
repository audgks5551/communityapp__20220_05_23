package com.example.backend.article.entity;

import com.example.backend.article.repository.ArticleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
public class ArticleEntityTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    public void 게시글_생성() {
        UUID uuid = UUID.randomUUID();
        Article article = new Article();
        article.setTitle("title");
        article.setContent("content");
        article.setUserId(uuid);

        Article savedArticle = articleRepository.save(article);

        assertThat(savedArticle).isSameAs(article);
        assertThat(savedArticle.getUserId().toString()).isEqualTo(uuid.toString());
        assertThat(savedArticle.getId()).isNotNull();
        assertThat(savedArticle.getCreatedDate()).isNotNull();
        assertThat(savedArticle.getModifiedDate()).isNotNull();
    }
}
