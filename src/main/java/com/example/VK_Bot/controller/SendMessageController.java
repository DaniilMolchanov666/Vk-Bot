package com.example.VK_Bot.controller;

import com.example.VK_Bot.service.ConfirmServerAddressService;
import com.example.VK_Bot.service.SendMessageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST контроллер для обработки POST запросов и передачи сообщений
 */
@RestController
@Slf4j
@AllArgsConstructor
public class SendMessageController {

    private final SendMessageService sendMessageService;

    private final ConfirmServerAddressService confirmationCallbackService;

    /**
     * Мето для отправки ответного сообщения пользователю, либо проверочной строки для
     * подтвреждения сервера для Callback API
     * @param request - тело запроса от сервера VK
     * @return - запрос для передачи сообщения
     */
    @PostMapping
    public ResponseEntity<String> getConfirmationAndSendString(@RequestBody final String request) {

        if (request.contains("confirmation")) {
            return confirmationCallbackService.sendMessageForConfirmServer();
        }
        return sendMessageService.repeatMessageByUser(request);
    }
}
