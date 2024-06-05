package com.example.VK_Bot.utils;

import com.example.VK_Bot.model.MessageFromUser;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Утилитарный парсер из JSON в новый обьект MessageFromUser
 */
@Slf4j
public final class CustomJsonParser {

    /**
     * Обьект ObjectMapper для парсинга JSON файлов
     */
    private static final ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

    /**
     * user_id значение из JSON строки (id пользователя ВК)
     */
    private static final String USER_ID = "from_id";

    /**
     * object.message.text значение из JSON строки (сообщение от пользователя ВК)
     */
    private static final String MESSAGE = "text";

    /**
     * Метод для десиарелизации из JSON в сущность MessageFromUser
     * для получения сообщения от пользователя
     * @param request - тело запроса от севера VK
     * @return - новый экземпляр класса MessageFromUser
     */
    @SneakyThrows
    public static MessageFromUser getMessageFromJson(String request) {

        Map<String, Object> jsonRequestMap = objectMapper.readValue(request, new TypeReference<>() {
        });

        double id = (double) jsonRequestMap.get(USER_ID);
        String text = (String) jsonRequestMap.get(MESSAGE);

        var messageFromUser = new MessageFromUser();
        messageFromUser.setText(text);
        messageFromUser.setUserId((int) id);

        return messageFromUser;
    }
}
