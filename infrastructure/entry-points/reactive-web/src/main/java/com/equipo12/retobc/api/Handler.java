package com.equipo12.retobc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.movement.Movement;
import com.equipo12.retobc.usecase.movement.MovementUseCase;
import com.equipo12.retobc.usecase.usecase.BalanceUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

	@Autowired
	BalanceUseCase balanceAndDetailsUseCase;
	
	@Autowired
	MovementUseCase movementUseCase;
	
    public Mono<ServerResponse> getBalanceHandler(ServerRequest serverRequest) {
    	Mono<AccountRS> resp = balanceAndDetailsUseCase.getBalanceUC();
//    	Mono<Movement> resp = movementUseCase.getMovememtUC();
    	
    	return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resp, AccountRS.class);
    }

}
