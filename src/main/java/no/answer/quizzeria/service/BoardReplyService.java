package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.BoardReplyDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.BoardReply;

public interface BoardReplyService {

    Long register(BoardReplyDTO dto);

    PageResultDTO<BoardReplyDTO, BoardReply> getList(PageRequestDTO requestDTO);

    BoardReplyDTO read(Long brno);

    void modify(BoardReplyDTO dto);

    default BoardReply dtoToEntity(BoardReplyDTO dto){
        BoardReply entity = BoardReply.builder()
                .brno(dto.getBrno())
                .content(dto.getContent())
                .member(dto.getMember())
                .board(dto.getBoard())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default BoardReplyDTO entityToDTO(BoardReply entity){
        BoardReplyDTO dto = BoardReplyDTO.builder()
                .brno(entity.getBrno())
                .content(entity.getContent())
                .member((entity.getMember()))
                .board(entity.getBoard())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
