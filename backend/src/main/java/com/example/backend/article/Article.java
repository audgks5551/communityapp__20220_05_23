package com.example.backend.article;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
public class Article {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
}
