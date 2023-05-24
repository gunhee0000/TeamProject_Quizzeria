package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.entity.Board;
import no.answer.quizzeria.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;



    @GetMapping({"/board/board_main"})
    public void Board(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Quizzeria_Board In" + pageRequestDTO);
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping({"/board/board_view", "/board/board_modify"})
    public void Board_view(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long bno, Model model){
        log.info("bno : " + bno);
        BoardDTO boardDTO = boardService.read(bno);
        log.info(boardDTO);
        model.addAttribute("dto", boardDTO);
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping({"/board/board_register"})
    public void register(){
        log.info("Board_register In");
    }
    @PostMapping({"/board/board_register"})
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);
        Long bno = boardService.register(dto);
        log.info("BNO: " + bno);
        redirectAttributes.addAttribute("msg", bno);
        return "redirect:/board/board_main";
    }

    @PostMapping("/board/board_modify")
    public String modify(BoardDTO dto
            , @ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO
            , RedirectAttributes redirectAttributes) {
        log.info("post modify................");
        log.info("dto..." + dto);

        boardService.modify(dto);

        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("type", pageRequestDTO.getType());
        redirectAttributes.addAttribute("keyword", pageRequestDTO.getKeyword());

        redirectAttributes.addAttribute("bno", dto.getBno());
        return "redirect:/board/board_view";
    }

    @GetMapping("/board/delete")
    public String delete(Long bno) {
        log.info("Delete Board: " + bno);
        boardService.delete(bno);
        return "redirect:/board/board_main";
    }

    @GetMapping("/board/like")
    public String like(Long bno) {
        log.info("Like Board: " + bno);
        boardService.increaseLikes(bno);
        return "redirect:/board/board_view?bno=" + bno;
    }



}