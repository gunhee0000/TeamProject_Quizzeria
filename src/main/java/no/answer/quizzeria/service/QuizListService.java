package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizListDTO;
import no.answer.quizzeria.entity.QuizList;

public interface QuizListService {

    Long register(QuizListDTO dto);

    PageResultDTO<QuizListDTO, QuizList> getList(PageRequestDTO requestDTO);

    QuizListDTO read(Long qlno);

    void modify(QuizListDTO dto);

    default QuizList dtoToEntity(QuizListDTO dto){
        QuizList entity = QuizList.builder()
                .qlno(dto.getQlno())
                .title(dto.getTitle())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .category(dto.getCategory())
                .views(dto.getViews())
                .likes(dto.getLikes())
                .build();
        return entity;
    }

    default QuizListDTO entityToDTO(QuizList entity){
        QuizListDTO dto = QuizListDTO.builder()
                .qlno(entity.getQlno())
                .title(entity.getTitle())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .category(entity.getCategory())
                .likes(entity.getLikes())
                .views(entity.getViews())
                .build();
        return dto;
    }
}
