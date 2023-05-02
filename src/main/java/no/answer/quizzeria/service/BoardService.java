package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Board;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    BoardDTO read(Long bno);

    void modify(BoardDTO dto);
    default Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default BoardDTO entityToDTO(Board entity){
        BoardDTO dto = BoardDTO.builder()
                .bno(entity.getBno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
