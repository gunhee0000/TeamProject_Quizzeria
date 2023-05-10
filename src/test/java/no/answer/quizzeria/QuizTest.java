package no.answer.quizzeria;

import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.entity.Quiz;
import no.answer.quizzeria.entity.QuizList;
import no.answer.quizzeria.entity.QuizListReply;
import no.answer.quizzeria.repository.QuizListReplyRepository;
import no.answer.quizzeria.repository.QuizListRepository;
import no.answer.quizzeria.repository.QuizReplyRepository;
import no.answer.quizzeria.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class QuizTest {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizListRepository quizListRepository;
    @Autowired
    private QuizListReplyRepository quizListReplyRepository;
    @Autowired
    private QuizReplyRepository quizReplyRepository;

    @Test
    public void makeDummyQuizList(){
        IntStream.rangeClosed(1,30).forEach(i -> {

            long ranMno = (long)((Math.random() * 30)+1);

            Member member = Member.builder().mno(ranMno).build();

            QuizList quizList = QuizList.builder()
                    .title("QuizTitle..." + i)
                    .category("Others")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }


    //객관식 만들때 사용
    //4개중에 정답이 뭔지 표시해줄 컬럼이 없어서 지금은 사용 못함
    @Test
    public void makeMultipleChoiceQuizDummy(){
        IntStream.rangeClosed(1,30).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            IntStream.rangeClosed(1,4).forEach( j -> {
                Quiz quiz = Quiz.builder()
                        .question("question..." + i)
                        .answer("answer..." + j)
                        .quizList(quizList)
                        .hidden("N")
                        .views((long)0)
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });
    }

    //주관식에 사용
    @Test
    public void makeOpenEndedQuizDummy(){
        IntStream.rangeClosed(1,30).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            Quiz quiz = Quiz.builder()
                    .question("question..." + i)
                    .answer("answer..." + i)
                    .quizList(quizList)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizRepository.save(quiz);
        });
    }

    @Test
    public void makeQuizListCommentsDummy(){
        IntStream.rangeClosed(1,30).forEach(i -> {

            QuizList quizList = QuizList.builder().qlno((long)i).build();
            int ranCommentsCount = (int)((Math.random()*5)+1);

            IntStream.rangeClosed(1, ranCommentsCount).forEach(j -> {
                long ranMNO = (long)((Math.random()+30)+1);
                Member member = Member.builder().mno(ranMNO).build();
                QuizListReply quizListReply = QuizListReply.builder()
                        .content("QuizListComment..." + j)
                        .member(member)
                        .quizList(quizList)
                        .hidden("N")
                        .likes((long)0)
                        .build();
                quizListReplyRepository.save(quizListReply);
            });
        });
    }

}
