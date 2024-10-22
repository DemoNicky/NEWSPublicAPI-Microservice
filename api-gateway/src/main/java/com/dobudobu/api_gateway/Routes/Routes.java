package com.dobudobu.api_gateway.Routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {
    @Bean
    public RouterFunction<ServerResponse> fileServiceRoute(){
        return GatewayRouterFunctions.route("file-service")
                .route(RequestPredicates.path("/api/v1/file/**"), HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> articleServiceRoute(){
        return GatewayRouterFunctions.route("article-management-service")
                .route(RequestPredicates.path("/api/v1/article/**"), HandlerFunctions.http("http://localhost:8081"))
                .build();
    }
}
