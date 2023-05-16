package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.BoardReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.ArrayList;

public interface BoardReplyRepository extends JpaRepository<BoardReply, Long>
        , QuerydslPredicateExecutor<BoardReply>
{
    @Query("SELECT br FROM BoardReply br LEFT JOIN Board bo ON bo.bno = br.board.bno WHERE br.board.bno = : bno")
    ArrayList<BoardReply> findAllByBno(long bno);
}
