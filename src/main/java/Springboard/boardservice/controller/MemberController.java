package Springboard.boardservice.controller;

import Springboard.boardservice.domain.Member;
import Springboard.boardservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService boardService;

    @GetMapping("/memberLoginForm")
    public String login() {
        return "member/memberLoginForm";
    }

    @GetMapping("/memberJoinForm")
    public String createUser(@ModelAttribute Member member) {
        boardService.joinUser(member);
        return "member/memberSaved";
    }


}

