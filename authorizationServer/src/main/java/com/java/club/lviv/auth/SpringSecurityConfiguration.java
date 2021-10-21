package com.java.club.lviv.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SpringSecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeRequests(r -> r.anyRequest().authenticated())
                .formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public UserDetailsService detailsService() {
        final var details = User.withDefaultPasswordEncoder().username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(details);
    }
}
