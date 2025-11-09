package org.example.aiprojekt.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "reasoning_tokens",
        "audio_tokens",
        "accepted_prediction_tokens",
        "rejected_prediction_tokens"
})


public class CompletionTokensDetails {

    @JsonProperty("reasoning_tokens")
    private Long reasoningTokens;
    @JsonProperty("audio_tokens")
    private Long audioTokens;
    @JsonProperty("accepted_prediction_tokens")
    private Long acceptedPredictionTokens;
    @JsonProperty("rejected_prediction_tokens")
    private Long rejectedPredictionTokens;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("reasoning_tokens")
    public Long getReasoningTokens() {
        return reasoningTokens;
    }

    @JsonProperty("reasoning_tokens")
    public void setReasoningTokens(Long reasoningTokens) {
        this.reasoningTokens = reasoningTokens;
    }

    @JsonProperty("audio_tokens")
    public Long getAudioTokens() {
        return audioTokens;
    }

    @JsonProperty("audio_tokens")
    public void setAudioTokens(Long audioTokens) {
        this.audioTokens = audioTokens;
    }

    @JsonProperty("accepted_prediction_tokens")
    public Long getAcceptedPredictionTokens() {
        return acceptedPredictionTokens;
    }

    @JsonProperty("accepted_prediction_tokens")
    public void setAcceptedPredictionTokens(Long acceptedPredictionTokens) {
        this.acceptedPredictionTokens = acceptedPredictionTokens;
    }

    @JsonProperty("rejected_prediction_tokens")
    public Long getRejectedPredictionTokens() {
        return rejectedPredictionTokens;
    }

    @JsonProperty("rejected_prediction_tokens")
    public void setRejectedPredictionTokens(Long rejectedPredictionTokens) {
        this.rejectedPredictionTokens = rejectedPredictionTokens;
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