package com.example.VK_Bot.utils;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.example.VK_Bot.model.MessageFromUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Slf4j
public final class CustomJsonParser {

    public static final ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

    @SneakyThrows
    public static MessageFromUser getMessageFromJson(String request) {
        Gson gson = new Gson();
//        MessageFromUser message = gson.fromJson(request, MessageFromUser.class);
        Map<String, Object> jsonRequestMap = objectMapper.readValue(request, new TypeReference<>() { });

        double id = (double) jsonRequestMap.get("from_id");
        String text = (String) jsonRequestMap.get("text");

        var messageFromUser = new MessageFromUser();
        messageFromUser.setText(text);
        messageFromUser.setUserId((int) id);

        return messageFromUser;
    }
}
