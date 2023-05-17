package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.QuizReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.ArrayList;

public interface QuizReplyRepository extends JpaRepository<QuizReply, Long>
        , QuerydslPredicateExecutor<QuizReply>
{
}
