package no.answer.quizzeria;

import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.entity.Role;
import no.answer.quizzeria.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void makeDummyMember(){
        IntStream.rangeClosed(1, 30).forEach(i -> {
            Member member = Member.builder()
                    .id("DummyID..." + i)
                    .password("1234")
                    .email("user"+ i +"@gmail.com")
                    .name("DummyUser..." + i)
                    .age(30)
                    .job("none")
                    .tel("010-1234-5678")
                    .addr("addr..." + i)
                    .hidden("N")
                    .enabled(true)
                    .build();
            memberRepository.save(member);
        });
    }



}
