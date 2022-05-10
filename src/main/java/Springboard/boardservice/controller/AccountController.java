package Springboard.boardservice.controller;

import Springboard.boardservice.dto.WritingDto;
import Springboard.boardservice.service.WritingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AccountController {

    private final WritingService writingService;


    @GetMapping("/")
    public String list(Model model) {
        List<WritingDto> writingDtoList = writingService.getWritingList();
        model.addAttribute("writingList", writingDtoList);
        return "list";
    }

    @GetMapping("/post")
    public String post(){
        return "post";
    }

    @GetMapping("/signUp")
    public String singUpForm(Model model){
        return "signUp";
    }

    @PostMapping("/post")
    public String write(WritingDto writingDto){
        writingService.save(writingDto);
        return "redirect:/";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") Long id, Model model) {
        WritingDto writingDto = writingService.getPost(id);
        model.addAttribute("post",writingDto);
        return "detail";
    }

    @GetMapping("/post/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        WritingDto writingDto = writingService.getPost(id);
        model.addAttribute("post", writingDto);
        return "edit";
    }

    @GetMapping("/post/edit/{id}")
    public String update(WritingDto writingDto) {
        writingService.save(writingDto);
        return "redirect:/";
    }

}

