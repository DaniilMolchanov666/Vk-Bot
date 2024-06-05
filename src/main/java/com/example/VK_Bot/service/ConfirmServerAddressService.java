package com.example.VK_Bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Сервис для подтверждения адреса локального сервера
 * с целью дальнейшего получения обновлений
 */
@Service
@Slf4j
public class ConfirmServerAddressService {

    private final String CODE_FOR_CHECK_SERVER;

    /**
     * Внедрение строки из application.properties
     * @param code - строка, которую должен вернуть сервер для его успешной регистрации
     */
    public ConfirmServerAddressService(@Value("${vk.code}") final String code) {
        this.CODE_FOR_CHECK_SERVER = code;
    }

    /**
     * Метод для отправки проверочной строки
     * @return - запрос для подтверждения адреса сервера
     */
    public ResponseEntity<String> sendMessageForConfirmServer() {
        log.info("Сообщение '{}' для подтверждения адреса сервера доставлено! {}",
                CODE_FOR_CHECK_SERVER, HttpStatus.OK);
        return new ResponseEntity<>(CODE_FOR_CHECK_SERVER, HttpStatus.OK);
    }
}
