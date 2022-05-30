package com.example.backend.article.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class RequestCreateArticle {
    @NotNull(message = "Title cannot be null")
    @Length(max = 50, message = "Title must be up to 50 characters long")
    @Length(min = 1, message = "Title must be at least one character")
    private String title;

    @NotNull(message = "Body cannot be null")
    @Length(min = 1, message = "Body must be at least one character")
    private String body;
}
