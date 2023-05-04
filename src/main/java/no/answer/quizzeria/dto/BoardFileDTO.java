package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Board;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardFileDTO {
    private Long bfno;

    private String ofile;

    private String sfile;

    private String filePath;

    private Board board;
}
