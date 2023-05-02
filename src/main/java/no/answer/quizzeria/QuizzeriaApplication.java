package no.answer.quizzeria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class QuizzeriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuizzeriaApplication.class, args);
    }

}
