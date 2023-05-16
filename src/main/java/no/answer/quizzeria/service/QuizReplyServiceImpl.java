package no.answer.quizzeria.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.dto.QuizReplyDTO;
import no.answer.quizzeria.entity.QQuizReply;
import no.answer.quizzeria.entity.QuizReply;
import no.answer.quizzeria.repository.QuizReplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class QuizReplyServiceImpl implements QuizReplyService{
    private final QuizReplyRepository repository;

    @Override
    public Long register(QuizReplyDTO dto) {
        log.info("QuizReply Register Start");
        QuizReply entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("QuizReply Register End");
        return entity.getQrno();
    }

    @Override
    public ArrayList<QuizReply> getList(long qno){
        log.info("QuizReply Page Build Start");
        ArrayList<QuizReply> quizReply = repository.findAllByQno(qno);
        log.info("QuizReply Page Build End");
        return quizReply;
    }

    @Override
    public QuizReplyDTO read(Long qrno){
        log.info("QuizReply Read Start");
        Optional<QuizReply> result = repository.findById(qrno);
        log.info("QuizReply Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(QuizReplyDTO dto){
        log.info("QuizReply Modify Start");
        Optional<QuizReply> result = repository.findById(dto.getQrno());

        if(result.isPresent()){
            QuizReply entity = result.get();

            entity.changeContent(dto.getContent());

            log.info("QuizReply Modify Success");
            repository.save(entity);
        }
        log.info("QuizReply Modify End");
    }
}
