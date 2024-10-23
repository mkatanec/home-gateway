package dev.beardy.homegateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfig {

    private static final String HOME_BACKEND = "http://home-backend:7000";
    private static final String FRONTEND = "http://home-frontend:3200";

    @Bean
    public RouteLocator customRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
            .route(p -> p.path("/api/home/**")
                .filters(f -> f.rewritePath("/api/home/?(?<segment>.*)", "/$\\{segment}")
                    .tokenRelay("keycloak"))
                .uri(HOME_BACKEND))

            .route(p -> p.path("/**")
                .uri(FRONTEND))
            .build();
    }

}
