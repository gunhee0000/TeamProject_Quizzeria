package no.answer.quizzeria.service;


import no.answer.quizzeria.dto.BoardFileDTO;
import no.answer.quizzeria.entity.BoardFile;

public interface BoardFileService {

    public Long saveFile(BoardFileDTO dto);

    default BoardFile dtoToEntity(BoardFileDTO dto){
        BoardFile entity = BoardFile.builder()
                .bfno(dto.getBfno())
                .ofile(dto.getOfile())
                .sfile(dto.getSfile())
                .filePath(dto.getFilePath())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default BoardFileDTO entityToDTO(BoardFile entity){
        BoardFileDTO dto = BoardFileDTO.builder()
                .bfno(entity.getBfno())
                .ofile(entity.getOfile())
                .sfile(entity.getSfile())
                .filePath(entity.getFilePath())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
