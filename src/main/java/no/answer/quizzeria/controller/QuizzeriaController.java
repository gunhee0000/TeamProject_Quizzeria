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
@RequestMapping("/Main")
@RequiredArgsConstructor
public class QuizzeriaController {
    private final BoardService boardService;

    @GetMapping("/Welcome")
    public void Main(){
        log.info("Quizzeria_Main In");
    }
    @GetMapping("/Home")
    public void Home(){
        log.info("Quizzeria_Home In");
    }
    @GetMapping("/main/Notice")
    public void Notice(){
        log.info("Quizzeria_Notice In");
    }
}
