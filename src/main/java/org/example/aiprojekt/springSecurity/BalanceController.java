package org.example.aiprojekt.springSecurity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class BalanceController {
    @GetMapping("/myBalance")
    public String getBalanceDetails() {
        return "Here are the balancedetails from db";
    }
}