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
    public PageResultDTO<QuizReplyDTO, QuizReply> getList(PageRequestDTO requestDTO){
        log.info("QuizReply Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("qrno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<QuizReply> result = repository.findAll(booleanBuilder, pageable);
        Function<QuizReply, QuizReplyDTO> fn = (entity->entityToDTO(entity));
        log.info("QuizReply Page Build End");
        return new PageResultDTO<>(result, fn);
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

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        log.info("QuizReply Search Start");
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QQuizReply qQuizReply = QQuizReply.quizReply;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qQuizReply.qrno.gt(0L);
        booleanBuilder.and(expression);
        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("c")) {
            conditionBuilder.or(qQuizReply.content.contains(keyword));
        }
        if (type.contains("i")) {
            conditionBuilder.or(qQuizReply.member.id.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        log.info("QuizReply Search End");
        return booleanBuilder;
    }
}
