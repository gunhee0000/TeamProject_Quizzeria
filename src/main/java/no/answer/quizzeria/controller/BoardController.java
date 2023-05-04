package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/")
@RequiredArgsConstructor
public class BoardController {

    @GetMapping("/board/Board_main")
    public void Board(){ log.info("Quizzeria_Board In");}
    @GetMapping("/board/Board_view")
    public void View(){log.info("Quizzeria_View In");}
}
