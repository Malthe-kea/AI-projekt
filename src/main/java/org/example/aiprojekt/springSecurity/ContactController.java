package org.example.aiprojekt.springSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ContactController {
    @GetMapping("/contact")
    public String getContactDetails() {
        return "Here are the contactdetails from db";
    }
}
