package com.equipo12.retobc.usecase.movement;

import com.equipo12.retobc.model.movement.Movement;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

//import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@AllArgsConstructor
public class MovementUseCase {

	private MovementGateway movementGateway;
	
	public Mono<Movement> getMovememtUC(){
		return movementGateway.getMovement();
	}
	
}
