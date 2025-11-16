package org.example.aiprojekt.model;

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
        "prompt_tokens",
        "completion_tokens",
        "total_tokens",
        "prompt_tokens_details",
        "completion_tokens_details"
})
public class Usage {

    @JsonProperty("prompt_tokens")
    private Long promptTokens;
    @JsonProperty("completion_tokens")
    private Long completionTokens;
    @JsonProperty("total_tokens")
    private Long totalTokens;
    @JsonProperty("prompt_tokens_details")
    private PromptTokensDetails promptTokensDetails;
    @JsonProperty("completion_tokens_details")
    private CompletionTokensDetails completionTokensDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("prompt_tokens")
    public Long getPromptTokens() {
        return promptTokens;
    }

    @JsonProperty("prompt_tokens")
    public void setPromptTokens(Long promptTokens) {
        this.promptTokens = promptTokens;
    }

    @JsonProperty("completion_tokens")
    public Long getCompletionTokens() {
        return completionTokens;
    }

    @JsonProperty("completion_tokens")
    public void setCompletionTokens(Long completionTokens) {
        this.completionTokens = completionTokens;
    }

    @JsonProperty("total_tokens")
    public Long getTotalTokens() {
        return totalTokens;
    }

    @JsonProperty("total_tokens")
    public void setTotalTokens(Long totalTokens) {
        this.totalTokens = totalTokens;
    }

    @JsonProperty("prompt_tokens_details")
    public PromptTokensDetails getPromptTokensDetails() {
        return promptTokensDetails;
    }

    @JsonProperty("prompt_tokens_details")
    public void setPromptTokensDetails(PromptTokensDetails promptTokensDetails) {
        this.promptTokensDetails = promptTokensDetails;
    }

    @JsonProperty("completion_tokens_details")
    public CompletionTokensDetails getCompletionTokensDetails() {
        return completionTokensDetails;
    }

    @JsonProperty("completion_tokens_details")
    public void setCompletionTokensDetails(CompletionTokensDetails completionTokensDetails) {
        this.completionTokensDetails = completionTokensDetails;
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