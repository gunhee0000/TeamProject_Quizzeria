package no.answer.quizzeria.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardReplyDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.BoardReply;
import no.answer.quizzeria.entity.QBoardReply;
import no.answer.quizzeria.repository.BoardReplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardReplyServiceImpl implements BoardReplyService{

    private final BoardReplyRepository repository;

    @Override
    public Long register(BoardReplyDTO dto) {
        log.info("BoardReply Register Start");
        BoardReply entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("BoardReply Register End");
        return entity.getBrno();
    }

    @Override
    public PageResultDTO<BoardReplyDTO, BoardReply> getList(PageRequestDTO requestDTO){
        log.info("BoardReply Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("brno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<BoardReply> result = repository.findAll(booleanBuilder, pageable);
        Function<BoardReply, BoardReplyDTO> fn = (entity->entityToDTO(entity));
        log.info("BoardReply Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardReplyDTO read(Long brno){
        log.info("BoardReply Read Start");
        Optional<BoardReply> result = repository.findById(brno);
        log.info("BoardReply Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(BoardReplyDTO dto){
        log.info("BoardReply Modify Start");
        Optional<BoardReply> result = repository.findById(dto.getBrno());

        if(result.isPresent()){
            BoardReply entity = result.get();

            entity.changeContent(dto.getContent());

            log.info("BoardReply Modify Success");
            repository.save(entity);
        }
        log.info("BoardReply Modify End");
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO){
        log.info("BoardReply Search Start");
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QBoardReply qBoardReply = QBoardReply.boardReply;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qBoardReply.brno.gt(0L);
        booleanBuilder.and(expression);
        if(type == null || type.trim().length() == 0){
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if(type.contains("c")){
            conditionBuilder.or(qBoardReply.content.contains(keyword));
        }
        if(type.contains("i")){
            conditionBuilder.or(qBoardReply.member.id.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        log.info("BoardReply Search End");
        return booleanBuilder;
    }
}
