package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(value = { AuditingEntityListener.class })
@ToString(exclude = "member")
public class QuizList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qlno;

    @Column(length = 50, nullable = false)
    private String title;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column
    private LocalDateTime modDate;

    @ColumnDefault("'N'")
    @Column(length = 10, nullable = false)
    private String hidden;

    @ColumnDefault("0")
    @Column
    private Long views;

    @ColumnDefault("0")
    @Column
    private Long likes;

    @Column(length = 100, nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Quiz> quiz;


    public void changeTitle(String title){
        this.title = title;
    }

    public void changeQuiz(List<Quiz> quiz){ this.quiz = quiz; }
}
