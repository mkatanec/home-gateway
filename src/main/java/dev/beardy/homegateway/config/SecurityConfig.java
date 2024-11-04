package dev.beardy.homegateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange(auth -> auth
                .anyExchange().authenticated())
            .oauth2Login(withDefaults())
            .oauth2Client(withDefaults())
            .csrf(ServerHttpSecurity.CsrfSpec::disable);
        return http.build();
    }

}
