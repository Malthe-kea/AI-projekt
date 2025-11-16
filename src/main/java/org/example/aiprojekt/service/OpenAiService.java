package org.example.aiprojekt.service;

import org.example.aiprojekt.model.Choice;
import org.example.aiprojekt.model.Message;
import org.example.aiprojekt.dto.OpenAIRequestDTO;
import org.example.aiprojekt.dto.ResponseDTO;

import org.example.aiprojekt.model.Usage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class OpenAiService {

    @Value("${app.api-key}")
    private String API_KEY;

    @Value("${app.url}")
    public String URL;

    @Value("${app.model}")
    public String MODEL;

    @Value("${app.temperature}")
    public double TEMPERATURE;

    @Value("${app.max_tokens}")
    public int MAX_TOKENS;

    @Value("${app.frequency_penalty}")
    public double FREQUENCY_PENALTY;

    @Value("${app.presence_penalty}")
    public int PRESENCE_PENALTY;

    @Value("${app.top_p}")
    public double TOP_P;

    private WebClient client;

    public OpenAiService() {
        this.client = WebClient.create();
    }

    public OpenAiService(WebClient client) {
        this.client = client;
    }

    public ResponseDTO makeRequest(String userPromp, String _systemMessage) {

        OpenAIRequestDTO chatRequest = new OpenAIRequestDTO();
        chatRequest.setModel(MODEL);
        List<Message> lstMessage = new ArrayList<>();
        lstMessage.add(new Message("system", _systemMessage));
        lstMessage.add(new Message("user", userPromp));
        chatRequest.setMessages(lstMessage);
        chatRequest.setN(3);
        chatRequest.setTemperature(TEMPERATURE);
        chatRequest.setMaxTokens(MAX_TOKENS);
        chatRequest.setStream(false);
        chatRequest.setPresencePenalty(PRESENCE_PENALTY);

        ResponseDTO response = client.post()
                .uri(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .headers(h -> h.setBearerAuth(API_KEY))
                .bodyValue(chatRequest)
                .retrieve()
                .bodyToMono(ResponseDTO.class)
                .block();

        List<Choice> lst = response.getChoices();
        Usage usg = response.getUsage();


        return response;

    }
}

