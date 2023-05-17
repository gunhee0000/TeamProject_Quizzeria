package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"quizList", "quizFile"})
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qno;

    @Column(length = 200, nullable = false)
    private String question;

    @Column(length = 100, nullable = false)
    private String type;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    @ColumnDefault("0")
    @Column
    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuizList quizList;

    @OneToMany(fetch = FetchType.LAZY)
    private List<QuizAnswer> quizAnswer;

    @OneToMany(fetch = FetchType.LAZY)
    private List<QuizFile> quizFile = new ArrayList<>();

    public void changeQuestion(String question){
        this.question = question;
    }

    public void changeQuizFile(List<QuizFile> quizFile){
        this.quizFile = quizFile;
    }

    public void changeQuizAnswer(List<QuizAnswer> quizAnswer){ this.quizAnswer = quizAnswer; }
}