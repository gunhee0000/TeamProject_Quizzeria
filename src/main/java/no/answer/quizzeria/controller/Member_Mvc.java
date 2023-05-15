package no.answer.quizzeria.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Member_Mvc implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/main/welcome");

        registry.addViewController("/member/member_login").setViewName("/member/member_login");
        registry.addViewController("/member/member_register").setViewName("/member/member_register");
    }

}
