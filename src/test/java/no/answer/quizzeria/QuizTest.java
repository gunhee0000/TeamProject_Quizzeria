package no.answer.quizzeria;

import no.answer.quizzeria.entity.*;
import no.answer.quizzeria.repository.*;
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
    @Autowired
    private QuizAnswerRepository quizAnswerRepository;
    @Autowired
    private MemberRepository memberRepository;

    public ArrayList<String> ranCategory() {
        ArrayList<String> result = new ArrayList<String>();
        //영어 수학 역사 과학 기타
        for (int i = 0; i < 1; i++) {
            result.add("english");
        }
        for (int i = 0; i < 1; i++) {
            result.add("math");
        }
        for (int i = 0; i < 1; i++) {
            result.add("history");
        }
        for (int i = 0; i < 1; i++) {
            result.add("science");
        }
        for (int i = 0; i < 1; i++) {
            result.add("others");
        }

        Collections.shuffle(result);

        return result;
    }

    public String randomType(){
        ArrayList<String> typeList = new ArrayList<>();
        typeList.add("Subjective");
        typeList.add("BinaryChoice");
        typeList.add("TernaryChoice");
        typeList.add("MultipleChoice");

        Collections.shuffle(typeList);

        return typeList.get(0);
    }

    @Test
    public void makeHomeQuiz() {
        Member member = (memberRepository.findById((long)1)).get();
        QuizList quizList = QuizList.builder()
                .title("기본문제")
                .category("others")
                .member(member)
                .hidden("N")
                .views((long) 0)
                .likes((long) 0)
                .build();
        quizListRepository.save(quizList);
        Quiz quiz = Quiz.builder()
                .question("우리 프로젝트의 이름은?")
                .quizList(quizList)
                .type("MultipleChoice")
                .hidden("N")
                .likes((long)99)
                .build();
        quizRepository.save(quiz);
        ArrayList<String> ranAnswer = new ArrayList<>();
        ranAnswer.add("N");
        ranAnswer.add("N");
        ranAnswer.add("N");
        ranAnswer.add("Y");
        Collections.shuffle(ranAnswer);
        IntStream.rangeClosed(1, 4).forEach(i -> {
            QuizAnswer quizAnswer = QuizAnswer.builder()
                    .answer("MultipleChoiceQuizAnswer..." + i)//데이터 베이스에서 직접 수정
                    .correct(ranAnswer.get(i - 1))
                    .quiz(quiz)
                    .hidden("N")
                    .build();
            quizAnswerRepository.save(quizAnswer);
        });
    }
    //////////////////////////////////////////////////////////퀴즈 타이틀

    @Test
    public void makeDummy(){
        IntStream.rangeClosed(2,6).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = (memberRepository.findById(ranMno)).get();
            QuizList quizList = QuizList.builder()
                    .title("Test Quiz List..." + i)
                    .category(category.get(i-2))
                    .member(member)
                    .hidden("N")
                    .likes((long)0)
                    .views((long)0)
                    .build();
            quizListRepository.save(quizList);
        });

        IntStream.rangeClosed(2,(int)quizListRepository.count()).forEach(i->{
            QuizList quizList = (quizListRepository.findById((long)i)).get();
            IntStream.rangeClosed(1,10).forEach(j->{
                String type = randomType();
                Quiz quiz = Quiz.builder()
                        .question("Question..." + j)
                        .quizList(quizList)
                        .type(type)
                        .hidden("N")
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });

        IntStream.rangeClosed(2, (int)quizRepository.count()).forEach(i -> {
            Quiz quiz = (quizRepository.findById((long)i)).get();
            switch (quiz.getType()){
                case "Subjective":
                    QuizAnswer subQuizAnswer = QuizAnswer.builder()
                            .answer("Answer..." + 1)
                            .correct("Y")
                            .quiz(quiz)
                            .hidden("N")
                            .build();
                    quizAnswerRepository.save(subQuizAnswer);
                    break;
                case "BinaryChoice":
                    IntStream.rangeClosed(1,2).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer BCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(BCQuizAnswer);
                    });
                    break;
                case "TernaryChoice":
                    IntStream.rangeClosed(1,3).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer TCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(TCQuizAnswer);
                    });
                    break;
                case "MultipleChoice":
                    IntStream.rangeClosed(1,4).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer MCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(MCQuizAnswer);
                    });
                    break;
            }
        });
    }
    @Test
    public void makeQuizListDummy(){

        IntStream.rangeClosed(2,6).forEach(i -> {
            ArrayList<String> category = ranCategory();
            long ranMno = (long)((Math.random() * 30)+1);
            Member member = (memberRepository.findById(ranMno)).get();
            QuizList quizList = QuizList.builder()
                    .title("Test Quiz List..." + i)
                    .category(category.get(i-2))
                    .member(member)
                    .hidden("N")
                    .likes((long)0)
                    .views((long)0)
                    .build();
            quizListRepository.save(quizList);
        });
    }
//    @Test
//    public void makeSubjectiveQuizListDummy() { //주관식
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            ArrayList<String> category = ranCategory();
//            long ranMno = (long) ((Math.random() * 30) + 1);
//            Member member = Member.builder().mno(ranMno).build();
//            QuizList quizList = QuizList.builder()
//                    .title("SubjectiveQuizTitle..." + i)
//                    .category(category.get(i - 1))
//                    .type("Subjective")
//                    .member(member)
//                    .hidden("N")
//                    .views((long) 0)
//                    .likes((long) 0)
//                    .build();
//            quizListRepository.save(quizList);
//        });
//    }
//
//    @Test
//    public void makeBinaryChoiceQuizListDummy() { //2지
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            ArrayList<String> category = ranCategory();
//            long ranMno = (long) ((Math.random() * 30) + 1);
//            Member member = Member.builder().mno(ranMno).build();
//
//            QuizList quizList = QuizList.builder()
//                    .title("BinaryChoiceQuizTitle..." + i)
//                    .category(category.get(i - 1))
//                    .type("BinaryChoice")
//                    .member(member)
//                    .hidden("N")
//                    .views((long) 0)
//                    .likes((long) 0)
//                    .build();
//            quizListRepository.save(quizList);
//        });
//    }
//
//    @Test
//    public void makeTernaryChoiceQuizListDummy() { //3지
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            ArrayList<String> category = ranCategory();
//            long ranMno = (long) ((Math.random() * 30) + 1);
//            Member member = Member.builder().mno(ranMno).build();
//
//            QuizList quizList = QuizList.builder()
//                    .title("TernaryChoiceQuizTitle..." + i)
//                    .category(category.get(i - 1))
//                    .type("TernaryChoice")
//                    .member(member)
//                    .hidden("N")
//                    .views((long) 0)
//                    .likes((long) 0)
//                    .build();
//            quizListRepository.save(quizList);
//        });
//    }
//
//    @Test
//    public void makeMultipleChoiceQuizListDummy() { //4지
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            ArrayList<String> category = ranCategory();
//            long ranMno = (long) ((Math.random() * 30) + 1);
//            Member member = Member.builder().mno(ranMno).build();
//
//            QuizList quizList = QuizList.builder()
//                    .title("MultipleChoiceQuizTitle..." + i)
//                    .category(category.get(i - 1))
//                    .type("MultipleChoice")
//                    .member(member)
//                    .hidden("N")
//                    .views((long) 0)
//                    .likes((long) 0)
//                    .build();
//            quizListRepository.save(quizList);
//        });
//    }

    ///////////////////////////////////////////////////////////////// 퀴즈 문제
    @Test
    public void makeTestQuizDummy(){
        IntStream.rangeClosed(2,(int)quizListRepository.count()).forEach(i->{
            QuizList quizList = (quizListRepository.findById((long)i)).get();
            IntStream.rangeClosed(1,10).forEach(j->{
                String type = randomType();
                Quiz quiz = Quiz.builder()
                        .question("Question..." + j)
                        .quizList(quizList)
                        .type(type)
                        .hidden("N")
                        .likes((long)0)
                        .build();
                quizRepository.save(quiz);
            });
        });
    }
//    @Test
//    public void makeSubjectiveQuizDummy() {
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            QuizList quizList = QuizList.builder().qlno((long)i).build();
//            IntStream.rangeClosed(1, 5).forEach(j -> {
//                Quiz quiz = Quiz.builder()
//                        .question("SubjectiveQuestion..." + i + "-" + j)
//                        .quizList(quizList)
//                        .hidden("N")
//                        .likes((long) 0)
//                        .build();
//                quizRepository.save(quiz);
//            });
//        });
//    }
//
//    @Test
//    public void makeBinaryChoiceQuizDummy() {
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            QuizList quizList = QuizList.builder().qlno((long) (i + 3)).build();
//            IntStream.rangeClosed(1, 5).forEach(j -> {
//                Quiz quiz = Quiz.builder()
//                        .question("BinaryChoiceQuestion..." + i + "-" + j)
//                        .quizList(quizList)
//                        .hidden("N")
//                        .likes((long) 0)
//                        .build();
//                quizRepository.save(quiz);
//            });
//        });
//    }
//
//    @Test
//    public void makeTernaryChoiceQuizDummy() {
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            QuizList quizList = QuizList.builder().qlno((long) (i + 6)).build();
//            IntStream.rangeClosed(1, 5).forEach(j -> {
//                Quiz quiz = Quiz.builder()
//                        .question("TernaryChoiceQuestion..." + i + "-" + j)
//                        .quizList(quizList)
//                        .hidden("N")
//                        .likes((long) 0)
//                        .build();
//                quizRepository.save(quiz);
//            });
//        });
//    }
//
//    @Test
//    public void makeMultipleChoiceQuizDummy() {
//        IntStream.rangeClosed(1, 3).forEach(i -> {
//            QuizList quizList = QuizList.builder().qlno((long) (i + 9)).build();
//            IntStream.rangeClosed(1, 5).forEach(j -> {
//                Quiz quiz = Quiz.builder()
//                        .question("MultipleChoiceQuestion..." + i + "-" + j)
//                        .quizList(quizList)
//                        .hidden("N")
//                        .likes((long) 0)
//                        .build();
//                quizRepository.save(quiz);
//            });
//        });
//    }

    ////////////////////////////////////////////////////////////////퀴즈 답
//typeList.add("Subjective");
//        typeList.add("BinaryChoice");
//        typeList.add("TernaryChoice");
//        typeList.add("MultipleChoice");

    @Test
    public void makeQuizAnswerDummy(){
        IntStream.rangeClosed(2, (int)quizRepository.count()).forEach(i -> {
            Quiz quiz = (quizRepository.findById((long)i)).get();
            switch (quiz.getType()){
                case "Subjective":
                    QuizAnswer subQuizAnswer = QuizAnswer.builder()
                            .answer("Answer..." + 1)
                            .correct("Y")
                            .quiz(quiz)
                            .hidden("N")
                            .build();
                    quizAnswerRepository.save(subQuizAnswer);
                    break;
                case "BinaryChoice":
                    IntStream.rangeClosed(1,2).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer BCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(BCQuizAnswer);
                    });
                    break;
                case "TernaryChoice":
                    IntStream.rangeClosed(1,3).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer TCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(TCQuizAnswer);
                    });
                    break;
                case "MultipleChoice":
                    IntStream.rangeClosed(1,4).forEach(j->{
                        ArrayList<String> ranAnswer = new ArrayList<>();
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("N");
                        ranAnswer.add("Y");
                        QuizAnswer MCQuizAnswer = QuizAnswer.builder()
                                .answer("Answer..." + j)
                                .correct(ranAnswer.get(j-1))
                                .quiz(quiz)
                                .hidden("N")
                                .build();
                        quizAnswerRepository.save(MCQuizAnswer);
                    });
                    break;
            }
        });
    }
//    @Test
//    public void makeSubjectiveQuizAnswerDummy() {
//        //3개의 문제 리스트에, 각리스트에 5개씩의 문제와 답
//        IntStream.rangeClosed(1, 15).forEach(i -> { //3개의 주관식 세트에 5개씩의 문제가 있어서 15개의 답 생성
//            Quiz quiz = Quiz.builder().qno((long) i).build();
//            QuizAnswer quizAnswer = QuizAnswer.builder()
//                    .answer("SubjectiveQuizAnswer..." + i)
//                    .correct("Y") //주관식의 답이라서 answer는 정답으로 처리, 입력 받은 값이랑 비교 해야함
//                    .quiz(quiz)
//                    .hidden("N")
//                    .build();
//            quizAnswerRepository.save(quizAnswer);
//        });
//    }
//
//    @Test
//    public void makeBinaryQuizAnswerDummy() {
//        IntStream.rangeClosed(1, 15).forEach(i -> {
//            Quiz quiz = Quiz.builder().qno((long) (i + 15)).build();
//            ArrayList<String> ranAnswer = new ArrayList<>();
//            ranAnswer.add("N");
//            ranAnswer.add("Y");
//            Collections.shuffle(ranAnswer);
//            IntStream.rangeClosed(1, 2).forEach(j -> {
//                //20개의 문제에 2개의 답리스트, 한개의 정답
//                QuizAnswer quizAnswer = QuizAnswer.builder()
//                        .answer("BinaryChoiceQuizAnswer..." + j)
//                        .correct(ranAnswer.get(j - 1))
//                        .quiz(quiz)
//                        .hidden("N")
//                        .build();
//                quizAnswerRepository.save(quizAnswer);
//            });
//        });
//    }
//
//    @Test
//    public void makeTernaryQuizAnswerDummy() {
//        IntStream.rangeClosed(1, 15).forEach(i -> {
//            Quiz quiz = Quiz.builder().qno((long) (i + 30)).build();
//            ArrayList<String> ranAnswer = new ArrayList<>();
//            ranAnswer.add("N");
//            ranAnswer.add("N");
//            ranAnswer.add("Y");
//            Collections.shuffle(ranAnswer);
//            IntStream.rangeClosed(1, 3).forEach(j -> {
//                QuizAnswer quizAnswer = QuizAnswer.builder()
//                        .answer("TernaryChoiceQuizAnswer..." + j)
//                        .correct(ranAnswer.get(j - 1))
//                        .quiz(quiz)
//                        .hidden("N")
//                        .build();
//                quizAnswerRepository.save(quizAnswer);
//            });
//        });
//    }
//
//    @Test
//    public void makeMultipleQuizAnswerDummy() {
//        IntStream.rangeClosed(1, 15).forEach(i -> {
//            Quiz quiz = Quiz.builder().qno((long) (i + 45)).build();
//            ArrayList<String> ranAnswer = new ArrayList<>();
//            ranAnswer.add("N");
//            ranAnswer.add("N");
//            ranAnswer.add("N");
//            ranAnswer.add("Y");
//            Collections.shuffle(ranAnswer);
//            IntStream.rangeClosed(1, 4).forEach(j -> {
//                QuizAnswer quizAnswer = QuizAnswer.builder()
//                        .answer("MultipleChoiceQuizAnswer..." + j)
//                        .correct(ranAnswer.get(j - 1))
//                        .quiz(quiz)
//                        .hidden("N")
//                        .build();
//                quizAnswerRepository.save(quizAnswer);
//            });
//        });
//    }



    ////////////////////////////////////////////////////////////////댓글
    @Test
    public void makeQuizListCommentsDummy() {
        IntStream.rangeClosed(1, (int)quizListRepository.count()).forEach(i -> {

            QuizList quizList = (quizListRepository.findById((long)i)).get();
            int ranCommentsCount = (int) ((Math.random() * 5) + 1);

            IntStream.rangeClosed(1, ranCommentsCount).forEach(j -> {
                long ranMNO = (long) ((Math.random() * 30) + 1);
                Member member = (memberRepository.findById(ranMNO)).get();
                QuizListReply quizListReply = QuizListReply.builder()
                        .content("QuizListComment..." + j)
                        .member(member)
                        .quizList(quizList)
                        .hidden("N")
                        .likes((long) 0)
                        .build();
                quizListReplyRepository.save(quizListReply);
            });
        });
    }

    @Test
    public void makeQuizCommentsDummy() {
        IntStream.rangeClosed(1, (int)quizRepository.count()).forEach(i -> {

            Quiz quiz = (quizRepository.findById((long)i)).get();
            int ranCommentsCount = (int) ((Math.random() * 5) + 1);

            IntStream.rangeClosed(1, ranCommentsCount).forEach(j -> {
                long ranMNO = (long) ((Math.random() * 30) + 1);
                Member member = (memberRepository.findById(ranMNO)).get();
                QuizReply quizReply = QuizReply.builder()
                        .content("QuizComment..." + j)
                        .member(member)
                        .quiz(quiz)
                        .hidden("N")
                        .likes((long) 0)
                        .build();
                quizReplyRepository.save(quizReply);
            });
        });
    }



    @Test
    public void test() {
        Member member = memberRepository.findById((long) 1).get();
        QuizList quizList = QuizList.builder()
                .title("Test")
                .category("others")
                .member(member)
                .hidden("N")
                .views((long) 0)
                .likes((long) 0)
                .build();
        quizListRepository.save(quizList);
        Quiz quiz = Quiz.builder()
                .question("테스트 문제 ")
                .quizList(quizList)
                .type("MultipleChoice")
                .hidden("N")
                .likes((long) 0)
                .build();
        quizRepository.save(quiz);
        ArrayList<String> ranAnswer = new ArrayList<>();
        ranAnswer.add("N");
        ranAnswer.add("N");
        ranAnswer.add("N");
        ranAnswer.add("Y");
        Collections.shuffle(ranAnswer);
        IntStream.rangeClosed(1, 4).forEach(i -> {
            QuizAnswer quizAnswer = QuizAnswer.builder()
                    .answer("MultipleChoiceQuizAnswer..." + i)
                    .correct(ranAnswer.get(i - 1))
                    .quiz(quiz)
                    .hidden("N")
                    .build();
            quizAnswerRepository.save(quizAnswer);
        });


//        QuizList quizList = quizListRepository.findById(7L).get();
//        Quiz quiz = quizRepository.findById(52L).get();
//
//        quiz.changeQuizAnswer(quizAnswerRepository.findAllById(Collections.singleton(quiz.getQno())));
//        System.out.println(quiz);
//        quizList.changeQuiz(quizRepository.findAllById(Collections.singleton(quizList.getQlno())));
//
//        quizListRepository.save(quizList);
//        quizRepository.save(quiz);
    }


}
