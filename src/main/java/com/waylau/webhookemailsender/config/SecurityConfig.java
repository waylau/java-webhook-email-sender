package com.waylau.webhookemailsender.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Security Config
 *
 * @author waylau.com
 * @version 2025/03/14 10:55
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())// 禁用 CSRF 防护
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/hi/webhookemailsender").permitAll()
                        .requestMatchers(HttpMethod.POST, "/webhook/**").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults());
        return http.build();
    }

}