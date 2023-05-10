package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bfno;

    @Column(length = 200, nullable = false)
    private String ofile;

    @Column(length = 200, nullable = false)
    private String sfile;

    @Column(length = 200, nullable = false)
    private String filePath;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;
}
