package no.answer.quizzeria.dto;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class MemberDTO {
    private String id;

    private Long mno;

    private String password;

    private String auth;

    private String email;

    private String name;

    private int age;

    private String job;

    private String tel;

    private String addr;

//    private String profileImg;

    private LocalDateTime regDate;

    private String hidden;

}
