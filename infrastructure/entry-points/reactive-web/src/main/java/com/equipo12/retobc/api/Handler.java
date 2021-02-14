package com.equipo12.retobc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.equipo12.retobc.model.balance.AccountRQ;
import com.equipo12.retobc.model.balance.BalancesRS;
import com.equipo12.retobc.model.balance.RequestBalance;
import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.MovementRS;
import com.equipo12.retobc.usecase.movement.MovementUseCase;
import com.equipo12.retobc.usecase.usecase.BalanceUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

	@Autowired
	BalanceUseCase balanceUseCase;
	
	@Autowired
	MovementUseCase movementUseCase;
	
    public Mono<ServerResponse> getBalanceHandler(ServerRequest request) {
    	Mono<MovementRS>  respMovement = request
                .bodyToMono(MovementRQ.class)
                .single()
                .flatMap(obj -> movementUseCase.getMovememtUC(obj));
    	
    	Mono<RequestBalance>  respBalance = request
								                .bodyToMono(MovementRQ.class)
								                .single()
								                .flatMap(mov -> balanceUseCase.getBalanceUC(
										                			AccountRQ.builder()
										                				.type(mov.getAccount().getType())
										                				.number(mov.getAccount().getNumber())
										                				.build())
								                		);
								                
    	
//    	Mono<RequestBalance> resp = balanceUseCase.getBalanceUC();
//    	Mono<MovementRS> resp = movementUseCase.getMovememtUC();
    	
    	return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
//                .body(respMovement, MovementRS.class);
                .body(respBalance, BalancesRS.class);
    }

}
