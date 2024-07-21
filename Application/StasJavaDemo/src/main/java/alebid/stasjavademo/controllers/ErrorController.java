package alebid.stasjavademo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping(value = {"/error", "/errors"})
    public String getError(){
        return "403";
    }
}
