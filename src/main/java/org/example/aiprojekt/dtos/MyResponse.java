package org.example.aiprojekt.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;



@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyResponse {
    String answer;
    List<Map<String, String>> messages;

    public MyResponse(){}
    public MyResponse(String answer) {
        this.answer = answer;
    }
    public MyResponse(String answer, List<Map<String,String>> messages) {
        this.answer = answer;
        this.messages = messages;
    }
}
