package no.answer.quizzeria.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.QuizList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDTO {
    private Long qno;

    private String question;

    private String answer;

    private QuizList quizList;

    private String hidden;
}
