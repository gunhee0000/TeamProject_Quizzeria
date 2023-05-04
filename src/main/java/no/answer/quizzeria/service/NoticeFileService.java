package no.answer.quizzeria.service;


import no.answer.quizzeria.dto.NoticeFileDTO;
import no.answer.quizzeria.entity.NoticeFile;

public interface NoticeFileService {


    public Long saveFile(NoticeFileDTO dto);
    default NoticeFile dtoToEntity(NoticeFileDTO dto){
        NoticeFile entity = NoticeFile.builder()
                .nfno(dto.getNfno())
                .ofile(dto.getOfile())
                .sfile(dto.getSfile())
                .filePath(dto.getFilePath())
                .notice(dto.getNotice())
                .build();
        return entity;
    }

    default NoticeFileDTO entityToDTO(NoticeFile entity){
        NoticeFileDTO dto = NoticeFileDTO.builder()
                .nfno(entity.getNfno())
                .ofile(entity.getOfile())
                .sfile(entity.getSfile())
                .filePath(entity.getFilePath())
                .notice(entity.getNotice())
                .build();
        return dto;
    }
}
