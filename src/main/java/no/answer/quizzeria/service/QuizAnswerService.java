package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.QuizAnswerDTO;
import no.answer.quizzeria.entity.QuizAnswer;

import java.util.List;

public interface QuizAnswerService {

    List<QuizAnswer> read(long qno);

    void createQuizAnswer(QuizAnswerDTO quizAnswerDTO);

    default QuizAnswer dtoTOEntity(QuizAnswerDTO dto){
        QuizAnswer entity = QuizAnswer.builder()
                .qano(dto.getQano())
                .answer(dto.getAnswer())
                .correct(dto.getCorrect())
                .quiz(dto.getQuiz())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }
    default QuizAnswerDTO entityToDTO(QuizAnswer entity){
        QuizAnswerDTO dto = QuizAnswerDTO.builder()
                .qano(entity.getQano())
                .answer(entity.getAnswer())
                .correct(entity.getCorrect())
                .quiz(entity.getQuiz())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
