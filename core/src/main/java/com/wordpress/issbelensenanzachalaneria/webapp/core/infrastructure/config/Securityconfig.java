package com.wordpress.issbelensenanzachalaneria.webapp.core.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Securityconfig {
    private static final String[] PUBLIC_URL = {
        "/api/users/"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).cors(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.authorizeHttpRequests(request -> request.requestMatchers(PUBLIC_URL).permitAll());
        autorizeWordPressContent(http);
        return http.build();
    }

    private void autorizeWordPressContent(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(
            request -> request.requestMatchers(HttpMethod.GET, "/api/wordpress/**").permitAll()
        );
    }
}
