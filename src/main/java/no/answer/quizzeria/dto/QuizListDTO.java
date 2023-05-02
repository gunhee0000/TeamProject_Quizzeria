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
public class QuizListDTO {
    private Long qlno;

    private String title;

    private LocalDateTime regDate;

    private LocalDateTime modDate;

    private Member member;

    private String hidden;

    private String category;
}
