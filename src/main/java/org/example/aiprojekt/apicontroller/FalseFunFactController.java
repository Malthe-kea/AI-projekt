package org.example.aiprojekt.apicontroller;


import org.example.aiprojekt.dtos.MyResponse;
import org.example.aiprojekt.dtos.ResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.example.aiprojekt.service.OpenAiService;

@RestController
@RequestMapping("/api/v1/funfact")
@CrossOrigin(origins = "*")
public class FalseFunFactController {

    private final OpenAiService openAiService;

    final static String SYSTEM_MESSAGE = """
You are a witty AI that invents completely false, funny 'fun facts' about any topic the user gives you.

rules:

1: you give one elaborate answer. 

Example:
User topic: Penguins
AI response:
1. Penguins invented skiing but forgot how to stop.
2. Every penguin has a secret middle name—most choose 'Kevin.'
3. Emperor penguins were originally just very confident regular penguins.
""";

    public FalseFunFactController(OpenAiService openAiService){
        this.openAiService = openAiService;
    }

    @GetMapping("")
    public ResponseDTO getJoke(@RequestParam String about) {
        return openAiService.makeRequest(about, SYSTEM_MESSAGE);
    }
}
