package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.BoardReplyDTO;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.service.BoardReplyService;
import no.answer.quizzeria.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    private final BoardReplyService boardReplyService;


    @GetMapping({"/board/board_main", "/board/board_new"})
    public void Board(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Quizzeria_Board In" + pageRequestDTO);
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping({"/board/board_view", "/board/board_modify"})
    public void Board_view(@ModelAttribute("requestDTO") PageRequestDTO pageRequestDTO, Long bno, Model model){
        log.info("bno" + bno);
        BoardDTO boardDTO = boardService.read(bno);
        log.info(boardDTO);
        model.addAttribute("reply_result", boardReplyService.getList(bno));
        model.addAttribute("dto", boardDTO);
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }

    @GetMapping("/board/board_register")
    public void register(){
        log.info("Board_register In");
    }
    @PostMapping("/board/board_register")
    public String registerPost(BoardDTO dto, RedirectAttributes redirectAttributes){
        log.info("dto..." + dto);
        Long bno = boardService.register(dto);
        log.info("BNO: " + bno);
        redirectAttributes.addAttribute("msg", bno);
        return "redirect:/board/board_view";
    }

}