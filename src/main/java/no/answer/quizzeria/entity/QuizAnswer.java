package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "quiz")
public class QuizAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qano;

    @Column(length = 200, nullable = false)
    private String answer;

    @Column(length = 4, nullable = false)
    private String correct;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    public void changeAnswer(String answer){
        this.answer = answer;
    }
}
