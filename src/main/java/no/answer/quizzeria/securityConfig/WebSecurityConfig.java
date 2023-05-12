//package no.answer.quizzeria.securityConfig;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.sql.DataSource;
//
//@Lazy
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//
//
//    private final DataSource dataSource;
//
//    @Autowired
//    public WebSecurityConfig(DataSource dataSource, PasswordEncoder passwordEncoder) {
//        this.dataSource = dataSource;
//    }
//
//    @Override //resources에 보안을 걸지 않는다 bootstrap 사용시 css폴더에 첨부해야만 사용가능
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/main/**", "/member/member_register").permitAll()
//                    .anyRequest().authenticated()
//                    .and()
//                .formLogin()
//                    .loginPage("/member/member_login")
//                    .permitAll()
//                    .and()
//                .logout()
//                    .permitAll();
//    }
//
//    @Lazy
//    @Autowired //Customizing Search Queries(사용자 테이블을 넘겨주는부분) AuthenticationManagerBuilder 사용시 spring에서 인증처리 제공
//    public void configureGlobal(AuthenticationManagerBuilder auth)
//            throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .passwordEncoder(passwordEncoder())
//                .usersByUsernameQuery("select id, password, enabled " //Authentication 인증처리
//                        + "from member "
//                        + "where id = ?")
//                .authoritiesByUsernameQuery("select m.id, r.rname " //Authorization 권한처리
//                        + "from Member_Role mr inner join member m on mr.member_mno = m.mno "
//                        + "inner join role r on mr.role_rno = r.rno "
//                        + "where m.id = ?");
//    }
//
//
//
//    @Bean //안전하게 암호화할수 있는 방법 spring 제공 ***현재 been충돌로 주석처리
//    public static PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
//
//
//
