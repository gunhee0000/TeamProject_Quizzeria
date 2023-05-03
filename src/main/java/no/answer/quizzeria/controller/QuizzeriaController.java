package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class QuizzeriaController {
    private final BoardService boardService;

    @GetMapping("/main/Welcome")
    public void Main(){
        log.info("Quizzeria_Main In");
    }
    @GetMapping("/main/Home")
    public void Home(){
        log.info("Quizzeria_Home In");
    }
    @GetMapping("/board/Board_main")
    public void Board(PageRequestDTO pageRequestDTO, Model model){
        log.info("Quizzeia_Board In");
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }
}
