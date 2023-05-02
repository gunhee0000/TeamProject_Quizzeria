package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.QuizListReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuizListReplyRepository extends JpaRepository<QuizListReply, Long>
        , QuerydslPredicateExecutor<QuizListReply>
{
}
