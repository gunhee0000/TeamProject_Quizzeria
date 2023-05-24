package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.QuizListDTO;
import no.answer.quizzeria.entity.Quiz;
import no.answer.quizzeria.entity.QuizAnswer;
import no.answer.quizzeria.service.QuizAnswerService;
import no.answer.quizzeria.service.QuizListReplyService;
import no.answer.quizzeria.service.QuizListService;
import no.answer.quizzeria.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
@RequestMapping("/quiz/")
@RequiredArgsConstructor
public class QuizController {

    private final QuizListService quizListService;
    private final QuizService quizService;
    private final QuizListReplyService quizListReplyService;
    private final QuizAnswerService quizAnswerService;

    @GetMapping("/quiz_main")
    public void Quiz_main(PageRequestDTO pageRequestDTO, Model model){
        log.info("Quiz_main In");
        int size = quizListService.getList(pageRequestDTO).getDtoList().size();
        model.addAttribute("quizlist", quizListService.getList(pageRequestDTO));
        model.addAttribute("size", size);
    }

    @GetMapping("/quiz_view")
    public void Quiz_view(Model model, long qlno, int index){
        log.info("Quiz_view In");
        QuizListDTO quizListDTO = quizListService.read(qlno);
        List<Quiz> quiz = quizService.read(qlno);
        List<QuizAnswer> quizAnswer = quizAnswerService.read(quiz.get(index).getQno());

//        System.out.println("quizListDTO >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + quizListDTO);
//        System.out.println("quiz >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + quiz);
//        System.out.println("quizAnswer >>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + quizAnswer);

        model.addAttribute("quizListDTO", quizListDTO);
        model.addAttribute("quiz", quiz);
        model.addAttribute("quizAnswer", quizAnswer);

        model.addAttribute("index", index);
        model.addAttribute("comments", quizListReplyService.getList(qlno));
    }

    @GetMapping("/quiz_create_title")
    public void Quiz_create_get(){

    }

    @PostMapping("/quiz_create_title")
    public String Quiz_create_post(){


        return "redirect:/quiz/quiz_create_question";
    }

    @GetMapping("/quiz_create_question")
    public void Quiz_question_get(){

    }

    @PostMapping("/quiz_create_question")
    public String Quiz_question_post(){

        return "redirect:/quiz/quiz_view";
    }
}
