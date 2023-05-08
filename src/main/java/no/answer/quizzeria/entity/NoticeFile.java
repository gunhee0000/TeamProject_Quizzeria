package no.answer.quizzeria.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class NoticeFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nfno;

    @Column(length = 200, nullable = false)
    private String ofile;

    @Column(length = 200, nullable = false)
    private String sfile;

    @Column(length = 200, nullable = false)
    private String filePath;
}
