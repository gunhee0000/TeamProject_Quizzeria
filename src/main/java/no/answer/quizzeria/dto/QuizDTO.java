package no.answer.quizzeria.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.QuizAnswer;
import no.answer.quizzeria.entity.QuizFile;
import no.answer.quizzeria.entity.QuizList;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDTO {
    private Long qno;

    private String question;

    private QuizList quizList;

    private String type;

    private String hidden;

    private Long likes;

    private List<QuizAnswer> quizAnswer;

    private List<QuizFile> quizFile;
}
