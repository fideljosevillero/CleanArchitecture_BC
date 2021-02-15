package com.equipo12.retobc.api;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RequestPredicates.contentType;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
public class Router {
	
	@Value("${routes.uri_balanceAndMovement:/balance-and-details}")
	private String path;
	
	@Bean
	public RouterFunction<ServerResponse> routerFunction(Handler handler) {
		return  route(
	            POST(path)
	                    .and(accept(MediaType.APPLICATION_JSON))
	                    .and(contentType(MediaType.APPLICATION_JSON)), 
	                    handler::getBalanceHandler);
	}
	
}
