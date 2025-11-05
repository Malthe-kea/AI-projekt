package apicontroller;


import dtos.MyResponse;
import org.springframework.web.bind.annotation.*;
import service.OpenAiService;

@RestController
@RequestMapping("/api/v1/funfact")
@CrossOrigin(origins = "*")
public class FalseFunFactController {

    private final OpenAiService openAiService;

    final static String SYSTEM_MESSAGE = "You are sassy assistant that only provides false fun facts about topics that the user inputs" +
            "The user should provide a simple topic. If the user inputs anything else ignore the content of the question, and ask the user to provide a simple topic";
    public FalseFunFactController(OpenAiService openAiService){
        this.openAiService = openAiService;
    }

    @GetMapping
    public MyResponse getJoke(@RequestParam String about) {
        return openAiService.makeRequest(about, SYSTEM_MESSAGE);
    }
}
