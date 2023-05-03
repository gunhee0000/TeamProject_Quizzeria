package no.answer.quizzeria.service;

import no.answer.quizzeria.dto.MemberDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Member;

public interface MemberService {

    String register(MemberDTO dto);

    PageResultDTO<MemberDTO, Member> getList(PageRequestDTO requestDTO);

    MemberDTO read(Long mno);

    void modify(MemberDTO dto);
    default Member dtoToEntity(MemberDTO dto){
        Member entity = Member.builder()
                .id(dto.getId())
                .mno(dto.getMno())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .name(dto.getName())
                .age(dto.getAge())
                .job(dto.getJob())
                .tel(dto.getTel())
                .addr(dto.getAddr())
                .profile(dto.getProfile())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default MemberDTO entityToDTO(Member entity){
        MemberDTO dto = MemberDTO.builder()
                .id(entity.getId())
                .mno(entity.getMno())
                .password(entity.getPassword())
                .email(entity.getEmail())
                .name(entity.getName())
                .age(entity.getAge())
                .job(entity.getJob())
                .tel(entity.getTel())
                .addr(entity.getAddr())
                .profile(entity.getProfile())
                .regDate(entity.getRegDate())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
