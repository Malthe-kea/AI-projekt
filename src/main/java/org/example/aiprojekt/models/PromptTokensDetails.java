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
        "cached_tokens",
        "audio_tokens"
})
public class PromptTokensDetails {

    @JsonProperty("cached_tokens")
    private Long cachedTokens;
    @JsonProperty("audio_tokens")
    private Long audioTokens;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cached_tokens")
    public Long getCachedTokens() {
        return cachedTokens;
    }

    @JsonProperty("cached_tokens")
    public void setCachedTokens(Long cachedTokens) {
        this.cachedTokens = cachedTokens;
    }

    @JsonProperty("audio_tokens")
    public Long getAudioTokens() {
        return audioTokens;
    }

    @JsonProperty("audio_tokens")
    public void setAudioTokens(Long audioTokens) {
        this.audioTokens = audioTokens;
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