package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Quiz;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuizAnswerDTO {
    private Long qano;

    private String answer;

    private String correct;

    private Quiz quiz;

    private String hidden;
}
