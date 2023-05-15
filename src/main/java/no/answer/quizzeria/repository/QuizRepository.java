package no.answer.quizzeria.repository;

import no.answer.quizzeria.dto.QuizDTO;
import no.answer.quizzeria.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface QuizRepository extends JpaRepository<Quiz, Long>
        , QuerydslPredicateExecutor<Quiz> {

    @Query("SELECT q FROM Quiz q LEFT JOIN QuizList ql ON ql.qlno = q.quizList.qlno WHERE q.quizList.qlno = :qlno")
    ArrayList<Quiz> findAllByQlno(@Param("qlno") long qlno);

}