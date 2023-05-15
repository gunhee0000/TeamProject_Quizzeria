package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/main")
@RequiredArgsConstructor
public class QuizzeriaController {
    private final BoardService boardService;
    private final NoticeService noticeService;
    private final QuizListService quizListService;
    private final QuizService quizService;
    private final QuizAnswerService quizAnswerService;

    @GetMapping("/welcome")
    public void Main(){
        log.info("Quizzeria_Main In");
    }
    @GetMapping("/home")
    public void Home(Model model){
        log.info("Quizzeria_Home In");
        model.addAttribute("notice", noticeService.getListHome());
        model.addAttribute("board", boardService.getListHome());
        model.addAttribute("quizListDTO", quizListService.read((long)17));
        model.addAttribute("quiz", quizService.read((long)17));
        model.addAttribute("quizAnswer", quizAnswerService.read(61));
//        model.addAttribute("todayQuiz", quizService.getRandomQuiz());
    }
    @GetMapping("/notice")
    public void Notice(){
        log.info("Quizzeria_Notice In");
    }
}
