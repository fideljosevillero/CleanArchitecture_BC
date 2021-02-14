package com.equipo12.retobc.usecase.movement;

import com.equipo12.retobc.model.movement.MovementRS;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

//import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
@AllArgsConstructor
public class MovementUseCase {

	private MovementGateway movementGateway;
	
	public Mono<MovementRS> getMovememtUC(){
		return movementGateway.getMovement();
	}
	
}
