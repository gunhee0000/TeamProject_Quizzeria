package no.answer.quizzeria.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.entity.Member;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardReplyDTO {
    private Long brno;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Member member;

    private Board board;

    private String hidden;
}
