package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.QuizReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.ArrayList;

public interface QuizReplyRepository extends JpaRepository<QuizReply, Long>
        , QuerydslPredicateExecutor<QuizReply>
{
    @Query("SELECT qr FROM QuizReply qr LEFT JOIN Quiz q ON q.qno = qr.quiz.qno WHERE qr.quiz.qno = :qno")
    ArrayList<QuizReply> findAllByQno(long qno);
}
