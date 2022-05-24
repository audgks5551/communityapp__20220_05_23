package com.example.backend.article.entity;

import com.example.backend.base.entity.DateManagement;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "articles")
public class Article extends DateManagement {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "article_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, unique = true)
    private String articleId;

    @Column(nullable = false)
    private String userId;
}
