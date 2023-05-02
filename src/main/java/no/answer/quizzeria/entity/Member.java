package no.answer.quizzeria.entity;
import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(value = { AuditingEntityListener.class })
@ToString
public class Member {

    @Id
    @Column(length = 30, nullable = false)
    private String id;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 50, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 3, nullable = false)
    private int age;

    @Column(length = 50, nullable = false)
    private String job;

    @Column(length = 20, nullable = false)
    private String tel;

    @Column(length = 50, nullable = false)
    private String addr;

    @Column(length = 50, nullable = false)
    private String profile;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regDate;

    @Column(length = 10, nullable = false)
    private String hidden;

    public void changePassword(String password){
        this.password = password;
    }

    public void changeJob(String job){
        this.job = job;
    }

    public void changeTel(String tel){
        this.tel = tel;
    }

    public void changeAddr(String addr){
        this.addr = addr;
    }

    public void changeProfile(String profile){
        this.profile = profile;
    }

}
