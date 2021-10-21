package com.java.club.lviv.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class ResourceServerConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/data/**").access("hasAuthority('SCOPE_data.read')")
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}
