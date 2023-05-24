package no.answer.quizzeria.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import no.answer.quizzeria.dto.BoardDTO;
import no.answer.quizzeria.dto.MemberDTO;
import no.answer.quizzeria.entity.Member;
import no.answer.quizzeria.service.BoardService;
import no.answer.quizzeria.service.MemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberServiceImpl memberService;

    @GetMapping("/member_register")
    public void register(){
    }

    @PostMapping("/member_register")
    public String register(MemberDTO memberDTO){
        memberService.save(memberDTO);
        return "redirect:/member/member_login";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/member/member_login";
    }

    @GetMapping({"/member_Info", "/member_modify"})
    public void getInfo() {
        log.info("Member_Info 접속...");
    }











}
