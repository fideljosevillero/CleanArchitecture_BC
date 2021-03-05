package com.equipo12.retobc.usecase.balanceandmovement;

import com.equipo12.retobc.model.balance.gateways.BalanceGateway;
import com.equipo12.retobc.model.balanceandmovement.BalanceAndMovementRS;
import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BalanceAndMovementUseCase {

	private BalanceGateway accountRQGateway;
	
	private MovementGateway movementGateway;
	
	public Mono<BalanceAndMovementRS> getBalanceAndMovement(MovementRQ movementRQ){
		
		return Mono.zip(accountRQGateway.getBalance(movementRQ.getAccount()), 
				movementGateway.getMovement(movementRQ))
		.flatMap(tuple -> Mono.just(new BalanceAndMovementRS(tuple.getT1(), tuple.getT2())));
		
	}
	
}
