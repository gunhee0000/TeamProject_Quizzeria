package no.answer.quizzeria.dto;

import lombok.*;
import no.answer.quizzeria.entity.Member;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BoardDTO {
    private Long bno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private String category;

    private Member member;

    private String hidden;

    private Long views;

    private Long likes;



}
