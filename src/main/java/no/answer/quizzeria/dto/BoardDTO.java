package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Member;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
    private Long bno;

    private String title;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private String category;

    private Member member;

    private String hidden;
}
