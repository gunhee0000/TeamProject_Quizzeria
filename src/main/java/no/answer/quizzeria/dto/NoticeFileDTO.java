package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.Notice;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NoticeFileDTO {

    private Long nfno;

    private String ofile;

    private String sfile;

    private String filePath;

    private String hidden;
}
