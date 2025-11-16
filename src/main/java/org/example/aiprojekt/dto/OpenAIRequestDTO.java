package org.example.aiprojekt.dto;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.aiprojekt.model.Message;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "model",
        "messages",
        "n",
        "temperature",
        "max_tokens",
        "stream",
        "presence_penalty"
})
public class OpenAIRequestDTO {

    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;
    @JsonProperty("n")
    private int n;
    @JsonProperty("temperature")
    private double temperature;
    @JsonProperty("max_tokens")
    private int maxTokens;
    @JsonProperty("stream")
    private Boolean stream;
    @JsonProperty("presence_penalty")
    private int presencePenalty;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("model")
    public String getModel() {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model) {
        this.model = model;
    }

    @JsonProperty("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @JsonProperty("messages")
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @JsonProperty("n")
    public int getN() {
        return n;
    }

    @JsonProperty("n")
    public void setN(int n) {
        this.n = n;
    }

    @JsonProperty("temperature")
    public double getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("max_tokens")
    public int getMaxTokens() {
        return maxTokens;
    }

    @JsonProperty("max_tokens")
    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }

    @JsonProperty("stream")
    public Boolean getStream() {
        return stream;
    }

    @JsonProperty("stream")
    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    @JsonProperty("presence_penalty")
    public int getPresencePenalty() {
        return presencePenalty;
    }

    @JsonProperty("presence_penalty")
    public void setPresencePenalty(int presencePenalty) {
        this.presencePenalty = presencePenalty;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}