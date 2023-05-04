package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.service.BoardService;
import no.answer.quizzeria.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping({"/board/Board_main", "/board/Board_view"})
    public void Board(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Quizzeria_Board In" + pageRequestDTO);
        model.addAttribute("result", boardService.getList(pageRequestDTO));
    }


//    @GetMapping("/board/Board_view")
//    public void View(PageRequestDTO pageRequestDTO, Model model){
//        log.info("Quizzeria_View In");
//        model.addAttribute("result", boardService.getList(pageRequestDTO));
//
//    }
}