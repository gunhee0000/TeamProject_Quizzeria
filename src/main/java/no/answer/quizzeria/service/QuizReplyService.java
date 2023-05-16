package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizReplyDTO;
import no.answer.quizzeria.entity.QuizReply;

import java.util.ArrayList;

public interface QuizReplyService {

    Long register(QuizReplyDTO dto);

    public ArrayList<QuizReply> getList(long qno);

    QuizReplyDTO read(Long qrno);

    void modify(QuizReplyDTO dto);

    default QuizReply dtoToEntity(QuizReplyDTO dto){
        QuizReply entity = QuizReply.builder()
                .qrno(dto.getQrno())
                .content(dto.getContent())
                .quiz(dto.getQuiz())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .likes(dto.getLikes())
                .build();
        return entity;
    }

    default QuizReplyDTO entityToDTO(QuizReply entity){
        QuizReplyDTO dto = QuizReplyDTO.builder()
                .qrno(entity.getQrno())
                .content(entity.getContent())
                .quiz(entity.getQuiz())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .likes(entity.getLikes())
                .build();
        return dto;
    }
}
