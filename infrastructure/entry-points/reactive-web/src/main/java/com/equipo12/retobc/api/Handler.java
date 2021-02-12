package com.equipo12.retobc.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.usecase.usecase.BalanceAndDetailsUseCase;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class Handler {

	@Autowired
	BalanceAndDetailsUseCase balanceAndDetailsUseCase;
	
    public Mono<ServerResponse> listenGETUseCase(ServerRequest serverRequest) {
//    	Mono<AccountRQ> accountRQ = Mono.just(AccountRQ.builder()
//    									.type("type")
//    									.number("number").build());
//    									
//        return ServerResponse.ok().body(accountRQ, AccountRQ.class);
    	Flux<AccountRS> resp = balanceAndDetailsUseCase.getBalanceAndMovement();
    	
    	return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(resp, AccountRS.class);
    }

}
