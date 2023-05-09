package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.NoticeDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Notice;

public interface NoticeService {

    Long register(NoticeDTO dto);

    PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO requestDTO);

    NoticeDTO read(Long nno);

    void modify(NoticeDTO dto);

    default Notice dtoToEntity(NoticeDTO dto){
        Notice entity = Notice.builder()
                .nno(dto.getNno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .member(dto.getMember())
                .hidden(dto.getHidden())
                .category(dto.getCategory())
                .views(dto.getViews())
                .likes(dto.getLikes())
                .noticeFile(dto.getNoticeFile())
                .build();
        return entity;
    }

    default NoticeDTO entityToDTO(Notice entity){
        NoticeDTO dto = NoticeDTO.builder()
                .nno(entity.getNno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .member(entity.getMember())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .hidden(entity.getHidden())
                .category(entity.getCategory())
                .likes(entity.getLikes())
                .views(entity.getViews())
                .noticeFile(entity.getNoticeFile())
                .build();
        return dto;
    }
}
