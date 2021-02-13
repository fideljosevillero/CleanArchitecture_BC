package com.equipo12.retobc.movement;

import org.springframework.stereotype.Component;

import com.equipo12.retobc.model.movement.Movement;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;

import reactor.core.publisher.Mono;

@Component
public class MovementAdapter implements MovementGateway {

	public Mono<Movement> getMovement(){
		return Mono.just(Movement.builder()
							.respuesta("Respuesta del Adapter!!!")
							.build());
	}
	
}
