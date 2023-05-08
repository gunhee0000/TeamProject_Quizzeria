package no.answer.quizzeria;

import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.repository.BoardRepository;
import no.answer.quizzeria.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuizzeriaApplicationTests {

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test
    void contextLoads() {
        Member member = Member.builder()
                .id("bemilinde")
                .job("3333")
                .age(3333)
                .password("333333")
                .addr("대구 동구 용33계역 32번 출구")
                .hidden("Y")
                .name("23323")
                .email("bemilinde@yahoo.com")

                .tel("011-12323-4598")
                .build();
        memberRepository.save(member);

        Board board = Board.builder()
                .title("asdf")
                .content("asdf")
                .hidden("b")
                .category("adf")
                .member(member)
                .build();
        boardRepository.save(board);
    }



}
