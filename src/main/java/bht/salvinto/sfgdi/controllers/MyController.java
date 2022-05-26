package bht.salvinto.sfgdi.controllers;

import bht.salvinto.sfgdi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private final GreetingService greetingService;

    public MyController(GreetingService greetingService) {
        // No qualifier provided:
        // Spring will pick the primary bean to inject
        this.greetingService = greetingService;
    }

    public String sayHello() {
        return greetingService.sayGreeting();
    }
}
