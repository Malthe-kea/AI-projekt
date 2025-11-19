package org.example.aiprojekt.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.aiprojekt.dtos.MistralRequestDTO;
import org.example.aiprojekt.dtos.ResponseDTO;
import org.example.aiprojekt.models.MistralMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;

@Service
public class MistralAIService {

    @Value("${app.api-key-mistral}")
    private String API_KEY;

    @Value("${app.url-mistral}")
    public String URL;

    @Value("${app.model-mistral}")
    public String MODEL;

    @Value("${app.temperature}")
    public double TEMPERATURE;

    @Value("${app.max_tokens}")
    public int MAX_TOKENS;

    @Value("${app.top_p}")
    public double TOP_P;

    private final WebClient client;
    private final ObjectMapper mapper;

    public MistralAIService() {
        this.client = WebClient.create();
        this.mapper = new ObjectMapper();
    }

    public ResponseDTO makeRequest(String userPrompt, String systemMessage) {
        try {
            // Byg request DTO
            MistralRequestDTO request = new MistralRequestDTO();
            request.setModel(MODEL);
            request.setTemperature(TEMPERATURE);
            request.setMax_tokens(MAX_TOKENS);
            request.setTop_p(TOP_P);

            List<MistralMessage> messages = new ArrayList<>();
            messages.add(new MistralMessage("system", systemMessage));
            messages.add(new MistralMessage("user", userPrompt));
            request.setMessages(messages);

            // Log request JSON
            String jsonRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(request);
            System.out.println("=== Mistral API Request ===");
            System.out.println(jsonRequest);
            System.out.println("===========================");

            // Send request
            ResponseDTO response = client.post()
                    .uri(URL)
                    .contentType(MediaType.APPLICATION_JSON)
                    .headers(h -> h.setBearerAuth(API_KEY))
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(ResponseDTO.class)
                    .block();

            return response;

        } catch (Exception e) {
            System.err.println("Error while making request to Mistral: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Failed to call Mistral API", e);
        }
    }
}

