package com.example.VK_Bot.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler {

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    private void nullRequestBodyExceptionHandler() {
        log.error("Запрос пустой!");
    }

    @ExceptionHandler(value =  NullPointerException.class)
    private void getNullExceptionHandler() {
        log.error("Данные равны null!");
    }

    @ExceptionHandler(value = {JsonMappingException.class, JsonProcessingException.class})
    private void parsingExceptionHandler() {
        log.error("Тело данного запроса невозможно запарсить!");
    }
}
