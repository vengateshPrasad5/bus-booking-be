package com.busbookingbe.app.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/booking/**","/api/v1/passenger/**").authenticated()
                .requestMatchers("/api/v1/bus/**").permitAll()
                .and().formLogin()
                .and().httpBasic();
        return http.build();
    }
}
