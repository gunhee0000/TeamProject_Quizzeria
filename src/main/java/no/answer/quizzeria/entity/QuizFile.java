package no.answer.quizzeria.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "quiz")
public class QuizFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qfno;

    @Column(length = 200, nullable = false)
    private String ofile;

    @Column(length = 200, nullable = false)
    private String sfile;

    @Column(length = 200, nullable = false)
    private String filePath;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;
}
