package no.answer.quizzeria;

import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.entity.Notice;
import no.answer.quizzeria.repository.NoticeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MainTest {
    @Autowired
    private NoticeRepository noticeRepository;

    @Test
    public void makeImportantNoticeDummy(){ //중요공지 더미
        Member member = Member.builder().mno(1).build();
        IntStream.rangeClosed(1,10).forEach(i -> {
            Notice notice = Notice.builder()
                    .title("Important Notice..." + i)
                    .content("중요 공지 입니다..." + i)
                    .category("Important")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            noticeRepository.save(notice);
        });
    }

    @Test
    public void makeGeneralNoticeDummy(){ //일반공지 더미
        Member member = Member.builder().mno(1).build();
        IntStream.rangeClosed(1,20).forEach(i -> {
            Notice notice = Notice.builder()
                    .title("General Notice..." + i)
                    .content("일반 공지 입니다..." + i)
                    .category("General")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            noticeRepository.save(notice);
        });
    }
}
