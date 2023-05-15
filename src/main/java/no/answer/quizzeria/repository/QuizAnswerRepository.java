package no.answer.quizzeria.repository;

import no.answer.quizzeria.dto.QuizAnswerDTO;
import no.answer.quizzeria.entity.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.ArrayList;

public interface QuizAnswerRepository  extends JpaRepository<QuizAnswer, Long>
        , QuerydslPredicateExecutor<QuizAnswer> {

    @Query("SELECT qa FROM QuizAnswer qa LEFT JOIN Quiz q ON q.qno = qa.quiz.qno WHERE qa.quiz.qno = :qno")
    ArrayList<QuizAnswer> findAllByQno(long qno);
}
