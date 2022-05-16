package Springboard.boardservice.controller;

import Springboard.boardservice.domain.Member;
import Springboard.boardservice.dto.MemberDto;
import Springboard.boardservice.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/memberJoinForm")
    public String addForm() {
        return "member/memberJoinForm";
    }

    @GetMapping("/memberLoginForm")
    public String login() {
        return "member/memberLoginForm";
    }

    @PostMapping("/memberJoinForm")
    public String createMember(@ModelAttribute MemberDto member) {
        memberService.joinUser(member);
        return "redirect:/";
    }

    @GetMapping("/memberLogingResult")
    public String loginResult(){
        return "member/memberLoginResult";
    }

    @GetMapping("/memberList")
    public String findAllMember(Model model){
        List<Member> members = memberService.findAll();
        model.addAttribute("members", members);
        return "member/memberList";
    }


}

