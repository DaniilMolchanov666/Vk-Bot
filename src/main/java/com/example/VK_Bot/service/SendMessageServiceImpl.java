package com.example.VK_Bot.service;

import com.example.VK_Bot.utils.CustomJsonParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class SendMessageServiceImpl {

    private final RestTemplate restTemplate = new RestTemplate();

    private final String ACCESS_TOKEN;

    public SendMessageServiceImpl(@Value("${vk.token}") final String token) {
        this.ACCESS_TOKEN = token;
    }

    public ResponseEntity<String> repeatMessageByUser(final String request) {
        var messageFromRequest = CustomJsonParser.getMessageFromJson(request);

        final String BOT_STARTING_PHRASE = "Вы сказали: ";
        final String messageForUser = BOT_STARTING_PHRASE + messageFromRequest.getText();

        final int RANDOM_ID_FOR_IGNORE_IDENTITY = 0;
        final String VERSION_API = "5.236";

        String requestUri = UriComponentsBuilder
                .fromUriString("https://api.vk.com/method/messages.send")
                .queryParam("access_token", ACCESS_TOKEN)
                .queryParam("random_id", RANDOM_ID_FOR_IGNORE_IDENTITY)
                .queryParam("message", messageForUser)
                .queryParam("user_id", messageFromRequest.getUserId())
                .queryParam("v", VERSION_API)
                .build()
                .toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(requestUri, String.class);

        int status = response.getStatusCode().value();

        log.info("Сообщение '{}' доставлено клиенту! {}", messageForUser, status);

        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
