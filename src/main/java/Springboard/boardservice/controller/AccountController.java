package Springboard.boardservice.controller;

import Springboard.boardservice.dto.WritingDto;
import Springboard.boardservice.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccountController {

    private WritingService writingService;

    public AccountController(WritingService writingService) {
        this.writingService = writingService;
    }

    @GetMapping("/")
    public String list(Model model) {
        List<WritingDto> writingDtoList = writingService.getWritingList();
        model.addAttribute("writingList", writingDtoList);
        return "list";
    }

    @GetMapping("/signUp")
    public String singUpForm(Model model){
        return "signUp";
    }

}

