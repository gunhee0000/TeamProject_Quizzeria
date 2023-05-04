package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizDTO;
import no.answer.quizzeria.entity.Quiz;

public interface QuizService {

    Long register(QuizDTO dto);

    PageResultDTO<QuizDTO, Quiz> getList(PageRequestDTO requestDTO);

    QuizDTO read(Long qno);

    void modify(QuizDTO dto);

    default Quiz dtoToEntity(QuizDTO dto){
        Quiz entity = Quiz.builder()
                .qno(dto.getQno())
                .question(dto.getQuestion())
                .answer(dto.getAnswer())
                .quizList(dto.getQuizList())
                .hidden(dto.getHidden())
                .views(dto.getViews())
                .likes(dto.getLikes())
                .build();
        return entity;
    }

    default QuizDTO entityToDTO(Quiz entity){
        QuizDTO dto = QuizDTO.builder()
                .qno(entity.getQno())
                .question(entity.getQuestion())
                .answer(entity.getAnswer())
                .quizList(entity.getQuizList())
                .hidden(entity.getHidden())
                .likes(entity.getLikes())
                .views(entity.getViews())
                .build();
        return dto;
    }
}
