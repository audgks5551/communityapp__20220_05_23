package com.example.backend.article.entity;

import com.example.backend.base.entity.DateManagement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "articles")
public class Article extends DateManagement {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    @Setter
    @Column(nullable = false)
    private String body;

    @Setter
    @Column(name = "article_id", columnDefinition = "VARCHAR(36)")
    private String articleId;

    @Setter
    @Column(name = "user_id", columnDefinition = "VARCHAR(36)", nullable = false)
    private String userId;
}
