package com.huang.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Security配置类
 *
 * @Author Brian
 * @Date 2021-05-13
 */
@Configuration
@EnableWebSecurity // 启用Web安全
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 需要配置这个支持password模式
     * support password grant type
     *
     * @Author Brian
     * @Date 2021-05-15
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable() // 关闭csrf
                .authorizeRequests()
                .antMatchers("/oauth/**", "/login/**", "/logout/**").permitAll()
                .anyRequest().authenticated()
                .and() // 关联配置
                .formLogin().permitAll();
    }
}
