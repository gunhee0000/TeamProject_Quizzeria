package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.MemberDTO;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.service.MemberService;
import no.answer.quizzeria.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Log4j2
@RequestMapping("/member/")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/UserInfo")
    public void userinfo(){
        log.info("userInfo.........");
    }

    @GetMapping("/member_login")
    public void login(){
        log.info("Login............");
    }

    @GetMapping("/member_register")
    public String getregister(){
        return "member/member_register";
    }
    @PostMapping("/member_register")
    public String register(MemberDTO dto, RedirectAttributes redirectAttributes){
        log.info("Register............");
        memberService.register(dto);
        redirectAttributes.addAttribute(memberService.register(dto));
        return "redirect:/";
    }

}
