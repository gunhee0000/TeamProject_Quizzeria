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
                .job("노숙자")
                .age(29)
                .password("1234")
                .addr("대구 동구 용계역 3번 출구")
                .hidden("Y")
                .name("최용성")
                .email("bemilinde@yahoo.com")
                .profile("asdfasasddfasf")
                .tel("011-123-4598")
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
