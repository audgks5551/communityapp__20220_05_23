package com.example.backend.article.entity;

import com.example.backend.base.entity.DateManagement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "articles")
public class Article extends DateManagement {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "article_id", columnDefinition = "BINARY(16)")
    private UUID id;

    @Setter
    @Column(nullable = false)
    private String title;

    @Lob
    @Setter
    @Column(nullable = false)
    private String content;

    @Setter
    @Column(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    private UUID userId;
}
