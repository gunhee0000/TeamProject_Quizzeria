package no.answer.quizzeria.entity;

import lombok.*;
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
@ToString(exclude = {"member", "quiz"})
public class QuizReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long qrno;

    @Column(length = 1500, nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @LastModifiedDate
    @Column
    private LocalDateTime modDate;

    @Column(length = 10, nullable = false)
    private String hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    public void changeContent(String content){
        this.content = content;
    }
}
