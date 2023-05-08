package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Quiz;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizFileDTO {
    private Long qfno;

    private String ofile;

    private String sfile;

    private String filePath;
}
