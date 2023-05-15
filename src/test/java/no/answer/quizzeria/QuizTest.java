package no.answer.quizzeria;

import no.answer.quizzeria.entity.*;
import no.answer.quizzeria.repository.QuizListReplyRepository;
import no.answer.quizzeria.repository.QuizListRepository;
import no.answer.quizzeria.repository.QuizReplyRepository;
import no.answer.quizzeria.repository.QuizRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
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

    public ArrayList<String> ranCategory(){
        ArrayList<String> result = new ArrayList<String>();
        //영어 수학 역사 과학 기타
        for(int i=0; i<4; i++){
            result.add("english");
        }
        for(int i=0; i<4; i++){
            result.add("math");
        }
        for(int i=0; i<4; i++){
            result.add("history");
        }
        for(int i=0; i<4; i++){
            result.add("science");
        }
        for(int i=0; i<4; i++){
            result.add("others");
        }

        Collections.shuffle(result);

        return result;
    }
    //////////////////////////////////////////////////////////퀴즈 타이틀
    @Test
    public void makeSubjectiveQuizListDummy(){ //주관식
        IntStream.rangeClosed(1,20).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = Member.builder().id(String.valueOf(ranMno)).build();
            QuizList quizList = QuizList.builder()
                    .title("SubjectiveQuizTitle..." + i)
                    .category(category.get(i-1))
                    .type("Subjective")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }

    @Test
    public void makeBinaryChoiceQuizListDummy(){ //2지
        IntStream.rangeClosed(1,20).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = Member.builder().id(String.valueOf(ranMno)).build();

            QuizList quizList = QuizList.builder()
                    .title("BinaryChoiceQuizTitle..." + i)
                    .category(category.get(i-1))
                    .type("BinaryChoice")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }

    @Test
    public void makeTernaryChoiceQuizListDummy(){ //3지
        IntStream.rangeClosed(1,20).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = Member.builder().id(String.valueOf(ranMno)).build();

            QuizList quizList = QuizList.builder()
                    .title("TernaryChoiceQuizTitle..." + i)
                    .category(category.get(i-1))
                    .type("TernaryChoice")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }

    @Test
    public void makeMultipleChoiceQuizListDummy(){ //4지
        IntStream.rangeClosed(1,20).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = Member.builder().id(String.valueOf(ranMno)).build();

            QuizList quizList = QuizList.builder()
                    .title("MultipleChoiceQuizTitle..." + i)
                    .category(category.get(i-1))
                    .type("MultipleChoice")
                    .member(member)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }

///////////////////////////////////////////////////////////////// 퀴즈 문제, 답
    @Test
    public void makeSubjectiveQuizDummy(){
        IntStream.rangeClosed(1,20).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            Quiz quiz = Quiz.builder()
                    .question("SubjectiveQuestion..." + i)
                    .answer("answer..." + i)
                    .correct("Y")
                    .quizList(quizList)
                    .hidden("N")
                    .views((long)0)
                    .likes((long)0)
                    .build();
            quizRepository.save(quiz);
        });
    }

    @Test
    public void makeBinaryChoiceQuizDummy(){
        IntStream.rangeClosed(21,40).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            ArrayList<String> ranAnswer = new ArrayList<>();
            ranAnswer.add("N");
            ranAnswer.add("Y");
            Collections.shuffle(ranAnswer);
            IntStream.rangeClosed(1,2).forEach( j -> {
                Quiz quiz = Quiz.builder()
                        .question("BinaryChoiceQuestion..." + (i-20))
                        .answer("answer..." + j)
                        .correct(ranAnswer.get(j-1))
                        .quizList(quizList)
                        .hidden("N")
                        .views((long)0)
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });
    }

    @Test
    public void makeTernaryChoiceQuizDummy(){
        IntStream.rangeClosed(41,60).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            ArrayList<String> ranAnswer = new ArrayList<>();
            ranAnswer.add("N");
            ranAnswer.add("N");
            ranAnswer.add("Y");
            Collections.shuffle(ranAnswer);
            IntStream.rangeClosed(1,3).forEach( j -> {
                Quiz quiz = Quiz.builder()
                        .question("TernaryChoiceQuestion..." + (i-40))
                        .answer("answer..." + j)
                        .correct(ranAnswer.get(j-1))
                        .quizList(quizList)
                        .hidden("N")
                        .views((long)0)
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });
    }

    @Test
    public void makeMultipleChoiceQuizDummy(){
        IntStream.rangeClosed(61,80).forEach(i -> {
            QuizList quizList = QuizList.builder().qlno((long)i).build();
            ArrayList<String> ranAnswer = new ArrayList<>();
            ranAnswer.add("N");
            ranAnswer.add("N");
            ranAnswer.add("N");
            ranAnswer.add("Y");
            Collections.shuffle(ranAnswer);
            IntStream.rangeClosed(1,4).forEach( j -> {
                Quiz quiz = Quiz.builder()
                        .question("MultipleChoiceQuestion..." + (i-60))
                        .answer("answer..." + j)
                        .correct(ranAnswer.get(j-1))
                        .quizList(quizList)
                        .hidden("N")
                        .views((long)0)
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });
    }


////////////////////////////////////////////////////////////////댓글
    @Test
    public void makeQuizListCommentsDummy(){
        IntStream.rangeClosed(1,80).forEach(i -> {

            QuizList quizList = QuizList.builder().qlno((long)i).build();
            int ranCommentsCount = (int)((Math.random()*5)+1);

            IntStream.rangeClosed(1, ranCommentsCount).forEach(j -> {
                long ranMNO = (long)((Math.random()*30)+1);
                Member member = Member.builder().id(String.valueOf(ranMNO)).build();
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

    @Test
    public void makeQuizCommentsDummy(){
        IntStream.rangeClosed(1, 200).forEach(i -> {

            Quiz quiz = Quiz.builder().qno((long)i).build();
            int ranCommentsCount = (int)((Math.random()*5)+1);

            IntStream.rangeClosed(1, ranCommentsCount).forEach(j -> {
                long ranMNO = (long)((Math.random()*30)+1);
                Member member = Member.builder().id(String.valueOf(ranMNO)).build();
                QuizReply quizReply = QuizReply.builder()
                        .content("QuizComment..." + j)
                        .member(member)
                        .quiz(quiz)
                        .hidden("N")
                        .likes((long)0)
                        .build();
                quizReplyRepository.save(quizReply);
            });
        });
    }

}
