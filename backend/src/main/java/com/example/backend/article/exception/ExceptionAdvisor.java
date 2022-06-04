package com.example.backend.article.exception;


import com.toedter.spring.hateoas.jsonapi.JsonApiError;
import com.toedter.spring.hateoas.jsonapi.JsonApiErrors;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ExceptionAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<JsonApiErrors> processValidationError(MethodArgumentNotValidException exception) {

        List<String> errorList = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity.badRequest().body(
                JsonApiErrors.create().withError(
                        JsonApiError.create()
                                .withTitle("유효성 검사 에러")
                                .withStatus(BAD_REQUEST.toString())
                                .withDetail(errorList.toString())
                )
        );
    }
}
