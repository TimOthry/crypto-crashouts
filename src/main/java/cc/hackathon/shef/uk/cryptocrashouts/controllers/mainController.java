package cc.hackathon.shef.uk.cryptocrashouts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class mainController {
    @GetMapping("/landing")
    public String index() {
        return "landing";
    }
}
