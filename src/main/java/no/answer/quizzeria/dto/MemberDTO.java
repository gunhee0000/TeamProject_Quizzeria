package no.answer.quizzeria.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
