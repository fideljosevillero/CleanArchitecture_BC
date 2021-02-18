package com.equipo12.retobc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.equipo12.retobc.model.balanceandmovement.BalanceAndMovementRS;
import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.MovementRS;
import com.equipo12.retobc.usecase.balanceandmovement.BalanceAndMovementUseCase;
import com.equipo12.retobc.usecase.balanceusecase.BalanceUseCase;
import com.equipo12.retobc.usecase.movement.MovementUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

	@Autowired
	BalanceUseCase balanceUseCase;
	
	@Autowired
	MovementUseCase movementUseCase;
	
	@Autowired
	BalanceAndMovementUseCase balanceAndMovementUseCase;
	
    public Mono<ServerResponse> getBalanceHandler(ServerRequest request) {
    	Mono<BalanceAndMovementRS>  respMovement = request
                .bodyToMono(MovementRQ.class)
                .single()
                .flatMap(obj -> balanceAndMovementUseCase.getBalanceAndMovement(obj));
    	
    	return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(respMovement, MovementRS.class);
    	
//    	return respMovement
//    		      .flatMap(s -> ServerResponse.ok()
//    		    	      .contentType(MediaType.TEXT_PLAIN)
//    		    	          .bodyValue(s))
//    	          .onErrorResume(e -> Mono.just("Error Personalizado - " + e.getMessage())
//    	        		  .flatMap(s -> ServerResponse.ok()
//    	        				  .contentType(MediaType.TEXT_PLAIN)
//    	        				  .bodyValue(s)));
    	

    }

}
