package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QuizRepository extends JpaRepository<Quiz, Long>
        , QuerydslPredicateExecutor<Quiz>
{
}
