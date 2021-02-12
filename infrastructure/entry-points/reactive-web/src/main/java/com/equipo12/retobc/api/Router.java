package com.equipo12.retobc.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class Router {
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(Handler handler) {
		return  route(
	            POST("/BalanceAndDetails")
	                    .and(accept(MediaType.APPLICATION_JSON))
	                    .and(contentType(MediaType.APPLICATION_JSON)), 
	                    handler::listenGETUseCase);
	}
	
}
