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

    @Column(length = 10, nullable = false)
    private String hidden;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    public void changeTitle(String title){
        this.title = title;
    }
}
