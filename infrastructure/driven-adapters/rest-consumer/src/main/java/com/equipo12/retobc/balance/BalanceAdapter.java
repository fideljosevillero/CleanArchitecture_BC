package com.equipo12.retobc.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.balance.AccountRQ;
import com.equipo12.retobc.model.balance.RequestBalance;
import com.equipo12.retobc.model.balance.gateways.BalanceGateway;

import reactor.core.publisher.Mono;

@Component
public class BalanceAdapter implements BalanceGateway {

	@Autowired
	private WebClient webClient;
	
	@Override
	public Mono<RequestBalance> getBalance(AccountRQ accountRQ) {		
		return webClient
                .post()
                .uri("https://young-tree-722.getsandbox.com:443/balance")
                .body(Mono.just(accountRQ), AccountRQ.class)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(RequestBalance.class);
	}

	
	
}
