package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.service.QuizListService;
import no.answer.quizzeria.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/quiz/")
@RequiredArgsConstructor
public class QuizController {

    private final QuizListService quizListService;

    @GetMapping("/quiz_main")
    public void Quiz_main(PageRequestDTO pageRequestDTO, Model model){
        log.info("Quiz_main In");
        model.addAttribute("quizlist", quizListService.getList(pageRequestDTO));
    }

    @GetMapping("/quiz_view")
    public void Quiz_view(){
        log.info("Quiz_view In");
    }
}
