package com.javaWithSpringCourse.smsBoot.config;

import com.javaWithSpringCourse.smsBoot.service.CustomUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by sailesh on 1/26/22.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public UserDetailsService userDetailsService() {return new CustomUserDetailService();}

    @Bean
    public BCryptPasswordEncoder passwordEncoder () { return new BCryptPasswordEncoder();}

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return authenticationProvider;
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws  Exception {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .loginPage("/login")
                    .usernameParameter("email")
                    .defaultSuccessUrl("/dashboard")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                ;

    }

    @Override
    public void configure(WebSecurity webSecurity) throws  Exception {
        webSecurity
                .ignoring()
                .antMatchers("/register", "/resources/**", "/css/**", "/js/**", "/static/**", "/h2-console/**");
    }

}
