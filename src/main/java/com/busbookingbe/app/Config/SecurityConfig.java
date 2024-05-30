package com.busbookingbe.app.Config;

import com.busbookingbe.app.Security.JwtTokenFilter;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    JwtTokenFilter jwtTokenFilter;


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf-> csrf.disable())
                .cors(cors-> cors.disable())
                .anonymous(anonymous->anonymous.disable());
        http.authorizeHttpRequests(auth->auth
//                .requestMatchers("/api/v1/passenger/**").authenticated()
                .requestMatchers("/api/v1/booking/**", "/api/auth/**", "/api/v1/bus/**").permitAll()
                .requestMatchers("swagger-ui/**", "/resources/**", "/static/**", "v3/api-docs/**").permitAll() //Swagger API
                .anyRequest().authenticated());
        http.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.exceptionHandling(exception -> exception.authenticationEntryPoint(new Http403ForbiddenEntryPoint()));
        http.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
