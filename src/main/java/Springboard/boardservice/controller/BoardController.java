package Springboard.boardservice.controller;

import Springboard.boardservice.dto.BoardDto;
import Springboard.boardservice.repository.BoardRepository;
import Springboard.boardservice.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;
    private final BoardRepository boardRepository;

    @GetMapping("/boardForm")
    public String addBoard() {
        return "/board/boardForm";
    }

    @PostMapping("/boardForm")
    public String createBoard(@ModelAttribute BoardDto boardDto, Model model){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        UserDetails userDetail = (UserDetails) principal;
        String username = userDetail.getUsername();

        boardDto.setCreatedBy(username);
        boardDto.setCountVisit(1L);
        boardService.saveBoard(boardDto);

        return "redirect:/";
    }

    @GetMapping("/boardList")


}
