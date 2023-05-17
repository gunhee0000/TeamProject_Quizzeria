package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizDTO;
import no.answer.quizzeria.entity.Quiz;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface QuizService {

    Long register(QuizDTO dto);

    PageResultDTO<QuizDTO, Quiz> getList(PageRequestDTO requestDTO);

//    Optional<Quiz> getRandomQuiz();

    List<Quiz> read(Long qlno);

//    void modify(QuizDTO dto);

    default Quiz dtoToEntity(QuizDTO dto){
        Quiz entity = Quiz.builder()
                .qno(dto.getQno())
                .question(dto.getQuestion())
                .quizList(dto.getQuizList())
                .hidden(dto.getHidden())
                .likes(dto.getLikes())
                .quizFile(dto.getQuizFile())
                .type(dto.getType())
                .quizAnswer(dto.getQuizAnswer())
                .build();
        return entity;
    }

    default QuizDTO entityToDTO(Quiz entity){
        QuizDTO dto = QuizDTO.builder()
                .qno(entity.getQno())
                .question(entity.getQuestion())
                .quizList(entity.getQuizList())
                .hidden(entity.getHidden())
                .likes(entity.getLikes())
                .quizFile(entity.getQuizFile())
                .type(entity.getType())
                .quizAnswer(entity.getQuizAnswer())
                .build();
        return dto;
    }
}
