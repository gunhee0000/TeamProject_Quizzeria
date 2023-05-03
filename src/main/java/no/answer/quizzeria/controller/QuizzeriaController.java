package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class QuizzeriaController {

    @GetMapping("/main/Welcome")
    public void Main(){
        log.info("Quizzeria_Main In");
    }
    @GetMapping("/main/Home")
    public void Home(){
        log.info("Quizzeria_Home In");
    }

}
