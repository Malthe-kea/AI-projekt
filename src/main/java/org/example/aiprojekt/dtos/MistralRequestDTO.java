package org.example.aiprojekt.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.example.aiprojekt.model.MistralMessage;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MistralRequestDTO {

    private String model;
    private List<MistralMessage> messages;
    private double temperature;
    private int max_tokens;
    private double top_p;

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public List<MistralMessage> getMessages() { return messages; }
    public void setMessages(List<MistralMessage> messages) { this.messages = messages; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getMax_tokens() { return max_tokens; }
    public void setMax_tokens(int max_tokens) { this.max_tokens = max_tokens; }

    public double getTop_p() { return top_p; }
    public void setTop_p(double top_p) { this.top_p = top_p; }
}
