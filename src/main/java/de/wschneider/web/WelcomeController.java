package de.wschneider.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class WelcomeController {

    @RequestMapping
    public String welcome() {

        return "static";
    }
}
