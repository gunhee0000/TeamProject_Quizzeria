package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.QuizList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuizListRepository extends JpaRepository<QuizList, Long>
        , QuerydslPredicateExecutor<QuizList>
{
}
