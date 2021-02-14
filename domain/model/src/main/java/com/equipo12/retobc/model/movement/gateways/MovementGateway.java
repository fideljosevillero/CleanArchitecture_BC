package com.equipo12.retobc.model.movement.gateways;

import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.MovementRS;

import reactor.core.publisher.Mono;

public interface MovementGateway {
	
	public Mono<MovementRS> getMovement(MovementRQ movementRQ);
	
}
