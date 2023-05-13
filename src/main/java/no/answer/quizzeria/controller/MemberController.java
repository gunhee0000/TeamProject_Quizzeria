package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.PageRequestDTO;
import no.answer.quizzeria.dto.PageResultDTO;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.service.MemberService;
import no.answer.quizzeria.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/UserInfo")
    public void userinfo(){
        log.info("userInfo.........");
    }

    @GetMapping("/member_login")
    public String login(){
        log.info("Login...");
        return "member/member_login";
    }

    @PostMapping("/member_login")
    public String loginPost(Member member){

        memberService.read(member.getMno());
        return "redirect:/main/home";
    };

    @GetMapping("/member_register")
    public String register(){
        return "member/member_register";
    }
    @PostMapping("/member_register")
    public String register(Member member){
        memberService.save(member);
        return "redirect:/main/welcome";
    }


}
