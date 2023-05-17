package no.answer.quizzeria.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.QuizAnswerDTO;
import no.answer.quizzeria.entity.QuizAnswer;
import no.answer.quizzeria.repository.QuizAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizAnswerServiceImpl implements QuizAnswerService{
    private final QuizAnswerRepository repository;

    @Override
    public List<QuizAnswer> read(long qno){
        log.info("QuizAnswer Read Start");
        List<QuizAnswer> quizAnswers = repository.findAll();
        List<QuizAnswer> result = new ArrayList<>();
        for(QuizAnswer dto : quizAnswers){
            if(dto.getQuiz().getQno() == qno){
                result.add(dto);
            }
        }
        log.info("Quiz Read End");

        return result;
    }

}
