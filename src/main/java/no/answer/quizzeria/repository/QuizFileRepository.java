package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.QuizFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizFileRepository extends JpaRepository<QuizFile, Long> {
}
