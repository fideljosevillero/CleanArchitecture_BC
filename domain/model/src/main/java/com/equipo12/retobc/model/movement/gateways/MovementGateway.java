package com.equipo12.retobc.model.movement.gateways;

import com.equipo12.retobc.model.movement.Movement;

import reactor.core.publisher.Mono;

public interface MovementGateway {
	
	public Mono<Movement> getMovement();
	
}
