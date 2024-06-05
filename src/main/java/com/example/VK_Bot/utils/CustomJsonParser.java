package com.example.VK_Bot.utils;

import com.example.VK_Bot.model.MessageFromUser;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Утилитарный парсер из JSON в новый обьект MessageFromUser
 */
@Slf4j
public final class CustomJsonParser {

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
    @SuppressWarnings("unchecked")
    public static MessageFromUser getMessageFromJson(String request) {

        Gson gson = new Gson();

        MessageFromUser message = gson.fromJson(request, MessageFromUser.class);

        Map<String, Object> jsonRequestMap = (Map<String, Object>) message.getObject().get("message");

        double id = (double) jsonRequestMap.get(USER_ID);
        String text = (String) jsonRequestMap.get(MESSAGE);

        var messageFromUser = new MessageFromUser();
        messageFromUser.setText(text);
        messageFromUser.setUserId((int) id);

        return messageFromUser;
    }
}
