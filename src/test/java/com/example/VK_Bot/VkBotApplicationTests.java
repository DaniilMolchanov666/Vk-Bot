package com.example.VK_Bot;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class VkBotApplicationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Проверка на отправку сообщения")
    void sendMessageTest() throws Exception {
        String PATH_FOR_JSON_FILE = "./src/test/java/resources/request.json";

        mockMvc.perform(post("http://localhost:10100")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(String.join("", Files.readAllLines(Path.of(PATH_FOR_JSON_FILE)))))
                .andExpect(status().isOk())
                .andExpect(content().string("ok"));
    }

    @Test
    @DisplayName("Проверка на пустое сообщение")
    void sendEmptyMessageTest() throws Exception {
        String emptyString = "";
        mockMvc.perform(post("http://localhost:10100")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(emptyString))
                .andExpect(content().string(emptyString));
    }
}
