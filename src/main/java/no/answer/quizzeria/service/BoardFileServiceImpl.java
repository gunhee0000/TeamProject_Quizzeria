package no.answer.quizzeria.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardFileDTO;
import no.answer.quizzeria.entity.BoardFile;
import no.answer.quizzeria.repository.BoardFileRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardFileServiceImpl implements BoardFileService{

    private final BoardFileRepository repository;

    @Override
    @Transactional
    public Long saveFile(BoardFileDTO dto){
        log.info("BoardFile Save Start");
        BoardFile entity = dtoToEntity(dto);
        log.info("BoardFile Save End");
        return entity.getBfno();
    }
}
