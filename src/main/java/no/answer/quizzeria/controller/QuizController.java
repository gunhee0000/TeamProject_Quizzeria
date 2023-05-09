package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/quiz/")
@RequiredArgsConstructor
public class QuizController {
    @GetMapping("/Quiz_main")
    public void Home(){
        log.info("Quiz_main In");
    }
}
