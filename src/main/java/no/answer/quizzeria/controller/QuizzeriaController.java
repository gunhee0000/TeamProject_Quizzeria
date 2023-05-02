package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/main/")
@RequiredArgsConstructor
public class QuizzeriaController {

    @GetMapping("/Welcome")
    public void Main(){
        log.info("Quizzeria_Main In");
    }
    @GetMapping("/Home")
    public void Home(){
        log.info("Quizzeria_Home In");
    }
    @GetMapping("/Board_main")
    public void Board(){ log.info("Quizzeia_Board In");}
}
