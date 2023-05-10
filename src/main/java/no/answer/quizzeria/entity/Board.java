package no.answer.quizzeria.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@EntityListeners(value = { AuditingEntityListener.class })
@ToString(exclude = {"member", "boardFile"})
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 50, nullable = false)
    private String title;

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

    @Column(length = 100, nullable = false)
    private String category;

    @ColumnDefault("0")
    @Column(length = 10)
    private Long views;

    @ColumnDefault("0")
    @Column(length = 10)
    private Long likes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    @OneToMany(fetch = FetchType.LAZY)
    private List<BoardFile> boardFile = new ArrayList<>();

    public void changeTitle(String title){
        this.title = title;
    }

    public void changeContent(String content){
        this.content = content;
    }

    public void changeBoardFile(List<BoardFile> boardFile){
        this.boardFile = boardFile;
    }
}
