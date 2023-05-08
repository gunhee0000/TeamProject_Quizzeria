package no.answer.quizzeria.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.entity.QBoard;
import no.answer.quizzeria.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardRepository repository;

    @Override
    public Long register(BoardDTO dto) {
        log.info("Board Register Start");
        Board entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("Board Register End");
        return entity.getBno();
    }

    @Override
    public PageResultDTO<BoardDTO, Board> getList(PageRequestDTO requestDTO){
        log.info("Board Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("bno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Board> result = repository.findAll(booleanBuilder, pageable);
        Function<Board, BoardDTO> fn = (entity->entityToDTO(entity));
        log.info("Board Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public BoardDTO read(Long bno){
        log.info("Board Read Start");
        Optional<Board> result = repository.findById(bno);
        log.info("Board Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(BoardDTO dto){
        log.info("Board Modify Start");
        Optional<Board> result = repository.findById(dto.getBno());

        if(result.isPresent()){
            Board entity = result.get();

            entity.changeContent(dto.getContent());
            entity.changeTitle(dto.getTitle());
            entity.changeBoardFile(dto.getBoardFile());

            log.info("Board Modify Success");
            repository.save(entity);
        }
        log.info("Board Modify End");
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        log.info("Board Search Start");
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QBoard qBoard = QBoard.board;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qBoard.bno.gt(0L);
        booleanBuilder.and(expression);
        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("t")) {
            conditionBuilder.or(qBoard.title.contains(keyword));
        }
        if (type.contains("c")) {
            conditionBuilder.or(qBoard.content.contains(keyword));
        }
        if (type.contains("i")) {
            conditionBuilder.or(qBoard.member.id.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        log.info("Board Search End");
        return booleanBuilder;
    }
}
