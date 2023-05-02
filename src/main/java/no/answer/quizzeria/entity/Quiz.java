package no.answer.quizzeria.entity;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "quizList")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qno;

    @Column(length = 200, nullable = false)
    private String question;

    @Column(length = 1500, nullable = false)
    private String answer;

    @Column(length = 10, nullable = false)
    private String hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuizList quizList;

    public void changeQuestion(String question){
        this.question = question;
    }

    public void changeAnswer(String answer){
        this.answer = answer;
    }
}
