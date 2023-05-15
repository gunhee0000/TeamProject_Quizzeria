//package no.answer.quizzeria.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
//
//@Service
//@Log4j2
//@RequiredArgsConstructor
//public class MemberService {


//    String register(MemberDTO dto);

//    PageResultDTO<MemberDTO, Member> getList(PageRequestDTO requestDTO);

//    MemberDTO read(Long mno);

//    Member save(Member member);

//    void modify(MemberDTO dto);

//    default Member dtoToEntity(MemberDTO dto){
//        Member entity = Member.builder()
//                .mno(dto.getMno())
//                .id(dto.getId())
//                .password(dto.getPassword())
//                .email(dto.getEmail())
//                .name(dto.getName())
//                .age(dto.getAge())
//                .job(dto.getJob())
//                .tel(dto.getTel())
//                .addr(dto.getAddr())
////                .profileImg(dto.getProfileImg())
//                .hidden(dto.getHidden())
//                .build();
//        return entity;
//    }
//
//    default MemberDTO entityToDTO(Member entity){
//        MemberDTO dto = MemberDTO.builder()
//                .id(entity.getId())
//                .mno(entity.getMno())
//                .password(entity.getPassword())
//                .email(entity.getEmail())
//                .name(entity.getName())
//                .age(entity.getAge())
//                .job(entity.getJob())
//                .tel(entity.getTel())
//                .addr(entity.getAddr())
////                .profileImg(entity.getProfileImg())
//                .regDate(entity.getRegDate())
//                .hidden(entity.getHidden())
//                .enabled(entity.isEnabled())
//                .build();
//        return dto;
//    }
//}
