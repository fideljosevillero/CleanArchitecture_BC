package com.equipo12.retobc.movement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.movement.Movement;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;

import reactor.core.publisher.Mono;

@Component
public class MovementAdapter implements MovementGateway {

	@Autowired
	private WebClient webClient;
	
	public Mono<Movement> getMovement(){
		
		return webClient
                .post()
                .uri("https://young-tree-722.getsandbox.com:443/movement")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Movement.class);
	}
	
}
