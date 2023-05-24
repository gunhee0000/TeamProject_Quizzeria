package no.answer.quizzeria.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizDTO;
import no.answer.quizzeria.entity.QQuiz;
import no.answer.quizzeria.entity.Quiz;
import no.answer.quizzeria.entity.QuizList;
import no.answer.quizzeria.repository.QuizListRepository;
import no.answer.quizzeria.repository.QuizRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{

    private final QuizRepository repository;

    @Override
    public Long register(QuizDTO dto) {
        log.info("Quiz Register Start");
        Quiz entity = dtoToEntity(dto);
        repository.save(entity);
        log.info(" Register End");
        return entity.getQno();
    }

    @Override
    public PageResultDTO<QuizDTO, Quiz> getList(PageRequestDTO requestDTO){
        log.info("Quiz Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("qno").descending());
        Page<Quiz> result = repository.findAll(pageable);
        Function<Quiz, QuizDTO> fn = (entity->entityToDTO(entity));
        log.info("Quiz Page Build End");
        return new PageResultDTO<>(result, fn);
    }

//    @Override
//    public Optional<Quiz> getRandomQuiz(){
//        log.info("Random Quiz Build Start");
//        int listSize = repository.findAll().size();
//        long ranNum = (long)((Math.random()*listSize)+1);
//        Optional<Quiz> quiz = repository.findById(ranNum);
//
//        return quiz;
//    }

    @Override
    public List<Quiz> read(Long qlno){
        log.info("Quiz Read Start");
        List<Quiz> result = repository.findAllByQlno(qlno);
        System.out.println(result);
        log.info("Quiz Read End");

        return result;
    }

//    @Override
//    public void modify(QuizDTO dto){
//        log.info("Quiz Modify Start");
//        Optional<Quiz> result = repository.findById(dto.getQno());
//
//        if(result.isPresent()){
//            Quiz entity = result.get();
//
//            entity.changeAnswer(dto.getAnswer());
//            entity.changeQuestion(dto.getQuestion());
//            entity.changeQuizFile(dto.getQuizFile());
//
//                    log.info("Quiz Modify Success");
//            repository.save(entity);
//        }
//        log.info("Quiz Modify End");
//    }
}
