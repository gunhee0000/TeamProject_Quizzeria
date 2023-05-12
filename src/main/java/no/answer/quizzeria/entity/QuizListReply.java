package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(value = { AuditingEntityListener.class })
@ToString(exclude = {"member", "quizList"})
public class QuizListReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qlrno;

    @Column(length = 1500, nullable = false)
    private String content;

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
    @Column(nullable = false)
    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private QuizList quizList;

    public void changeContent(String content){
        this.content = content;
    }
}
