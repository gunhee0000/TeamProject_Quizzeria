package no.answer.quizzeria.repository;

import no.answer.quizzeria.entity.NoticeFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeFileRepository extends JpaRepository<NoticeFile, Long> {
}
