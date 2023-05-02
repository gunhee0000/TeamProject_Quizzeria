package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizListReplyDTO;
import no.answer.quizzeria.entity.QuizListReply;

public interface QuizListReplyService {

    Long register(QuizListReplyDTO dto);

    PageResultDTO<QuizListReplyDTO, QuizListReply> getList(PageRequestDTO requestDTO);

    QuizListReplyDTO read(Long qlrno);

    void modify(QuizListReplyDTO dto);

    default QuizListReply dtoToEntity(QuizListReplyDTO dto){
        QuizListReply entity = QuizListReply.builder()
                .qlrno(dto.getQlrno())
                .content(dto.getContent())
                .quizList(dto.getQuizList())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default QuizListReplyDTO entityToDTO(QuizListReply entity){
        QuizListReplyDTO dto = QuizListReplyDTO.builder()
                .qlrno(entity.getQlrno())
                .content(entity.getContent())
                .quizList(entity.getQuizList())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
