package com.liuliu.webflux.learning.demo02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class MyRoutes {

    @Bean
    RouterFunction<ServerResponse> home() {
        return RouterFunctions.route(RequestPredicates.GET("/"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("Home page")));
    }

    @Bean
    RouterFunction<ServerResponse> about() {
        return RouterFunctions.route(RequestPredicates.GET("/about"),
                request -> ServerResponse.ok().body(BodyInserters.fromObject("About page")));
    }
}
