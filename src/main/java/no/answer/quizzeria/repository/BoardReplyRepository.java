package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>
        , QuerydslPredicateExecutor<BoardReply>
{
}
