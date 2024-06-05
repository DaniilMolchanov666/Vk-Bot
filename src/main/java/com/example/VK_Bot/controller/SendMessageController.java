package com.example.VK_Bot.controller;

import com.example.VK_Bot.service.ConfirmServerAddressServiceImpl;
import com.example.VK_Bot.service.SendMessageServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class SendMessageController {

    private final SendMessageServiceImpl sendMessageService;

    private final ConfirmServerAddressServiceImpl confirmationCallbackService;

    @PostMapping
    public ResponseEntity<String> getConfirmationAndSendString(@RequestBody String request) {

        if (request.contains("confirmation")) {
            return confirmationCallbackService.sendMessageForConfirmServer();
        }
        return sendMessageService.repeatMessageByUser(request);
    }
}
