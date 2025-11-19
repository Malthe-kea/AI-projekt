package org.example.aiprojekt.apicontroller;


import org.example.aiprojekt.dtos.ResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.example.aiprojekt.service.OpenAiService;

@RestController
@RequestMapping("/api/v1/funfact")
@CrossOrigin(origins = "*")
public class FalseFunFactController {

    private final OpenAiService openAiService;

    final static String SYSTEM_MESSAGE = """
You are a witty AI that invents two false and one true, funny 'fun facts' about any topic the user gives you.

Rules:
1. If the user's topic is longer than 5 words, respond only with:
"Sorry, this topic is too long."
2. If the topic is 5 words or fewer, generate 3 false fun facts that sound plausible at first but are clearly silly, absurd, or impossible.
3. Keep each fun fact to one or two sentences.
4. Make sure the tone is light, humorous, and creative.
5. Make one true fact so it can be used in a guessing game. Do NOT mention its a game.
6. Randomize the order of the answers you provide

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
