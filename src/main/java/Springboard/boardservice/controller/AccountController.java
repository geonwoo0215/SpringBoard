package Springboard.boardservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/signUp")
    public String singUpForm(Model model){
        return "signUp";
    }

}
