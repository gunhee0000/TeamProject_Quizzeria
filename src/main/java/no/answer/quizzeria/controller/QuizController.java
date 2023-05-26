package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.QuizAnswerDTO;
import no.answer.quizzeria.dto.QuizDTO;
import no.answer.quizzeria.dto.QuizListDTO;
import no.answer.quizzeria.entity.Quiz;
import no.answer.quizzeria.entity.QuizAnswer;
import no.answer.quizzeria.entity.QuizList;
import no.answer.quizzeria.service.QuizAnswerService;
import no.answer.quizzeria.service.QuizListReplyService;
import no.answer.quizzeria.service.QuizListService;
import no.answer.quizzeria.service.QuizService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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
        model.addAttribute("quizlist", quizListService.getList(pageRequestDTO));
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
    public String Quiz_create_post(QuizListDTO quizListDTO, RedirectAttributes redirectAttributes){
        QuizList quizList = quizListService.createQuizList(quizListDTO);
        redirectAttributes.addAttribute("quizList", quizList);
        return "redirect:/quiz/quiz_create_question";
    }

    @GetMapping("/quiz_create_question")
    public void Quiz_question_get(){
    }

    @PostMapping("/quiz_create_question")
    public String Quiz_question_post(Quiz quiz, List<QuizAnswer> quizAnswer, RedirectAttributes redirectAttributes){

        //엔티티가 한번에 넘어오는게 문제
        //받아온 엔티티를 컨트롤러에서 나눠서 저장?
        //그럴려면 전부(Quiz, QuizAnswer)를 저장하고 있는 Entity가 추가로 필요

//        QuizListDTO quizListDTO = quizListService.read(qlno);
//        quizDTO.setQuizList(quizListService.dtoToEntity(quizListDTO));

//        Quiz quizEntity = quizService.createQuiz(quiz);
//
//        log.info(quizAnswer);
//
//        for(int i=0; i<quizAnswer.size(); i++){
//            quizAnswerService.createQuizAnswer(quizAnswer.get(i));
//        }
//
////        long qlno = quiz.getQuizList().getQlno();
//        redirectAttributes.addAttribute("qlno", quizEntity.getQuizList().getQlno());
//
        return "redirect:/quiz/quiz_create_question";
    }
}
