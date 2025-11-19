package org.example.aiprojekt.apicontroller;

import org.example.aiprojekt.dtos.ResponseDTO;
import org.example.aiprojekt.service.MistralAIService;
import org.example.aiprojekt.service.OpenAiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class FactCheckerController {

    //private OpenAiService openAiService;


    private MistralAIService mistralAIService;

    public FactCheckerController(MistralAIService mistralAIService) {
        this.mistralAIService = mistralAIService;
    }

    final static String SYSTEM_MESSAGE = """
            You are a fact-checking AI. \s
            You will receive several statements, and your job is to figure out which one (or more) is false. \s
            For each statement, briefly explain your reasoning — why you think it’s true or false — and what evidence or logic supports your judgment. \s
            If you’re not completely sure, say so and explain what kind of information would confirm it. \s
            Focus on clarity and reasoning, not on rigid formatting or citations. \s
            At the end, clearly state which statement(s) you believe are false and summarize why.
            
""";
    @PostMapping("/factchecker")
    public ResponseEntity<ResponseDTO> checkFact(@RequestBody Map<String, String> request) {
        String statement = request.get("statement");
        String topic = request.get("topic");


        ResponseDTO response = mistralAIService.makeRequest(
                "Tjek om dette udsagn er korrekt: \"" + statement + "\"\nEmne: " + topic,
                SYSTEM_MESSAGE
        );

        return ResponseEntity.ok(response);
    }

//    @PostMapping("/factchecker")
//    public ResponseEntity<ResponseDTO> checkFact(@RequestBody Map<String, String> request) {
//        String statement = request.get("statement");
//        String topic = request.get("topic");
//
//
//        ResponseDTO response = openAiService.makeRequest(
//                "Tjek om dette udsagn er korrekt: \"" + statement + "\"\nEmne: " + topic,
//                SYSTEM_MESSAGE
//        );
//
//        return ResponseEntity.ok(response);
//    }
}
