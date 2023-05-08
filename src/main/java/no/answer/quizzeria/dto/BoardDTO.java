package no.answer.quizzeria.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import no.answer.quizzeria.entity.BoardFile;
import no.answer.quizzeria.entity.Member;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.List;

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

    private Long views;

    private Long likes;

    private List<BoardFile> boardFile;
}
