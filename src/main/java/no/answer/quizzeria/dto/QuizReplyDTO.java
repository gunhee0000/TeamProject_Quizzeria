package no.answer.quizzeria.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.entity.Quiz;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizReplyDTO {
    private Long qrno;

    private String content;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Member member;

    private Quiz quiz;

    private String hidden;
}
