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

    private final MemberService memberService;
    private final BoardService boardService;

    @GetMapping("/board/Board_main")
    public void Board(PageRequestDTO pageRequestDTO, Model model) {
        log.info("Quizzeria_Board In" + pageRequestDTO);
        model.addAttribute("boardResult", boardService.getList(pageRequestDTO));
        model.addAttribute("memberResult", memberService.getList(pageRequestDTO));
    }


    @GetMapping("/board/Board_view")
    public void View(){log.info("Quizzeria_View In");
    }
}