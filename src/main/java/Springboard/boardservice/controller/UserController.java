package Springboard.boardservice.controller;

import Springboard.boardservice.domain.User;
import Springboard.boardservice.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final BoardService boardService;

    @GetMapping("/userLoginForm")
    public String login() {
        return "user/userLoginForm";
    }

    @GetMapping("/userJoinForm")
    public String createUser(@ModelAttribute User user) {
        boardService.join(user);
        return "user/userSaved";
    }


}

