package com.example.backend.article.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RequestCreateArticle {
    @NotNull(message = "title을 입력해주세요")
    @Size(max = 50, message = "title은 최대 50글자 입니다")
    @Size(min = 1, message = "title은 최소 1글자 입니다")
    private String title;

    @NotNull(message = "body를 입력해주세요")
    @Size(min = 1, message = "body는 최소 1글자입니다")
    private String body;
}
