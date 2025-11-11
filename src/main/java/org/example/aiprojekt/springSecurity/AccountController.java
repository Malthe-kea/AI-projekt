package org.example.aiprojekt.springSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class AccountController {
    @GetMapping("/myAccount")
    public String getAccountDetails() {
        return "Here are the accountdetails from db";
    }
}
