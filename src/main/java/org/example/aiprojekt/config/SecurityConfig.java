package org.example.aiprojekt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // VIGTIGT: Ellers blokerer POST requests fra JS
                .cors(cors -> {})
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/**").permitAll() // 👈 ÅBEN DIT API
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {})
                .formLogin(form -> form.disable());

        return http.build();
    }
}
