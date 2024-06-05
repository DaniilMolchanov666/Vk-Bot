package com.example.VK_Bot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfirmServerAddressServiceImpl {

    public final String CODE_FOR_CHECK_SERVER;

    public ConfirmServerAddressServiceImpl(@Value("${vk.code}") String code) {
        this.CODE_FOR_CHECK_SERVER = code;
    }

    public ResponseEntity<String> sendMessageForConfirmServer() {
        log.info("Сообщение '{}' для подтверждения адреса сервера доставлено! {}",
                CODE_FOR_CHECK_SERVER, HttpStatus.OK);
        return new ResponseEntity<>(CODE_FOR_CHECK_SERVER, HttpStatus.OK);
    }
}
