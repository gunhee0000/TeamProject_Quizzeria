package no.answer.quizzeria.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.QuizAnswerDTO;
import no.answer.quizzeria.entity.QuizAnswer;
import no.answer.quizzeria.repository.QuizAnswerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizAnswerServiceImpl implements QuizAnswerService{
    private final QuizAnswerRepository repository;

    @Override
    public ArrayList<QuizAnswer> read(long qno){
        log.info("QuizAnswer Read Start");
        ArrayList<QuizAnswer> result = repository.findAllByQno(qno);
        log.info("Quiz Read End");

        return result;
    }

}
