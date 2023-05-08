package no.answer.quizzeria.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.NoticeDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Notice;
import no.answer.quizzeria.entity.QNotice;
import no.answer.quizzeria.repository.NoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeRepository repository;

    @Override
    public Long register(NoticeDTO dto){
        log.info("Notice Register Start");
        Notice entity = dtoToEntity(dto);
        repository.save(entity);
        log.info("Notice Register End");
        return entity.getNno();
    }

    @Override
    public PageResultDTO<NoticeDTO, Notice> getList(PageRequestDTO requestDTO) {
        log.info("Notice Page Build Start");
        Pageable pageable = requestDTO.getPageable(Sort.by("nno").descending());
        BooleanBuilder booleanBuilder = getSearch(requestDTO);
        Page<Notice> result = repository.findAll(booleanBuilder, pageable);
        Function<Notice, NoticeDTO> fn = (entity -> entityToDTO(entity));
        log.info("Notice Page Build End");
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public NoticeDTO read(Long nno){
        log.info("Notice Read Start");
        Optional<Notice> result = repository.findById(nno);
        log.info("Notice Read End");
        return result.isPresent() ? entityToDTO(result.get()) : null;
    }

    @Override
    public void modify(NoticeDTO dto){
        log.info("Notice Modify Start");
        Optional<Notice> result = repository.findById(dto.getNno());

        if(result.isPresent()){
            Notice entity = result.get();

            entity.changeContent(dto.getContent());
            entity.changeTitle(dto.getTitle());
            entity.changeNoticeFile(dto.getNoticeFile());

            log.info("Notice Modify Success");
            repository.save(entity);
        }
        log.info("Notice Modify End");
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        log.info("Notice Search Start");
        String type = requestDTO.getType();
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        QNotice qNotice = QNotice.notice;
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qNotice.nno.gt(0L);
        booleanBuilder.and(expression);
        if (type == null || type.trim().length() == 0) {
            return booleanBuilder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();
        if (type.contains("t")) {
            conditionBuilder.or(qNotice.title.contains(keyword));
        }
        if (type.contains("c")) {
            conditionBuilder.or(qNotice.content.contains(keyword));
        }
        if (type.contains("i")) {
            conditionBuilder.or(qNotice.member.id.contains(keyword));
        }
        booleanBuilder.and(conditionBuilder);
        log.info("Notice Search End");
        return booleanBuilder;
    }
}
