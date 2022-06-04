package com.example.backend.article.form;

import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "게시글 생성 폼")
public class CreateArticleForm {
    @Schema(description = "제목", maxLength = 50, minLength = 1)
    @NotNull(message = "title을 입력해주세요")
    @Size(max = 50, message = "title은 최대 50글자 입니다")
    @Size(min = 1, message = "title은 최소 1글자 입니다")
    private String title;

    @Schema(description = "내용", minLength = 1)
    @NotNull(message = "body를 입력해주세요")
    @Size(min = 1, message = "body는 최소 1글자입니다")
    private String body;
}
