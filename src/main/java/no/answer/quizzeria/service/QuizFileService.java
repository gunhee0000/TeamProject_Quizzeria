package no.answer.quizzeria.service;


import no.answer.quizzeria.dto.QuizFileDTO;
import no.answer.quizzeria.entity.QuizFile;

public interface QuizFileService {

    public Long saveFile(QuizFileDTO dto);

    default QuizFile dtoToEntity(QuizFileDTO dto){
        QuizFile entity = QuizFile.builder()
                .qfno(dto.getQfno())
                .ofile(dto.getOfile())
                .sfile(dto.getSfile())
                .filePath(dto.getFilePath())
                .hidden(dto.getHidden())
                .build();
        return entity;
    }

    default QuizFileDTO entityToDTO(QuizFile entity){
        QuizFileDTO dto = QuizFileDTO.builder()
                .qfno(entity.getQfno())
                .ofile(entity.getOfile())
                .sfile(entity.getSfile())
                .filePath(entity.getFilePath())
                .hidden(entity.getHidden())
                .build();
        return dto;
    }
}
