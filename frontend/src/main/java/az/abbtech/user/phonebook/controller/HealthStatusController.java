package az.abbtech.user.phonebook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthStatusController {
    @GetMapping("/status")
    public String listUsers() {
        return "ok";
    }

}
