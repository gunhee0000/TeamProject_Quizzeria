package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.MemberDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.entity.Member;

import javax.transaction.Transactional;
import java.util.ArrayList;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO);

    PageResultDTO<BoardDTO, Board> getListHome(PageRequestDTO requestDTO);

//    ArrayList<Board> getListHome();

    BoardDTO read(Long bno);

    void modify(BoardDTO dto);

    void delete(Long bno);

    void increaseLikes(Long bno);

    default Board dtoToEntity(BoardDTO dto){
        Board entity = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .category(dto.getCategory())
                .views(dto.getViews())
                .likes(dto.getLikes())
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
                .category(entity.getCategory())
                .likes(entity.getLikes())
                .views(entity.getViews())
                .build();
        return dto;
    }



}
