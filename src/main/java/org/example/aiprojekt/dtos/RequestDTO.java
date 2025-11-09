package org.example.aiprojekt.dtos;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.example.aiprojekt.models.Message;

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
public class RequestDTO {

    @JsonProperty("model")
    private String model;
    @JsonProperty("messages")
    private List<Message> messages;
    @JsonProperty("n")
    private Long n;
    @JsonProperty("temperature")
    private Long temperature;
    @JsonProperty("max_tokens")
    private Long maxTokens;
    @JsonProperty("stream")
    private Boolean stream;
    @JsonProperty("presence_penalty")
    private Long presencePenalty;
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
    public Long getN() {
        return n;
    }

    @JsonProperty("n")
    public void setN(Long n) {
        this.n = n;
    }

    @JsonProperty("temperature")
    public Long getTemperature() {
        return temperature;
    }

    @JsonProperty("temperature")
    public void setTemperature(Long temperature) {
        this.temperature = temperature;
    }

    @JsonProperty("max_tokens")
    public Long getMaxTokens() {
        return maxTokens;
    }

    @JsonProperty("max_tokens")
    public void setMaxTokens(Long maxTokens) {
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
    public Long getPresencePenalty() {
        return presencePenalty;
    }

    @JsonProperty("presence_penalty")
    public void setPresencePenalty(Long presencePenalty) {
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