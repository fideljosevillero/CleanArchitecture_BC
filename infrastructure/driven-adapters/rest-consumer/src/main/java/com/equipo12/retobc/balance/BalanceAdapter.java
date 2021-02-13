package com.equipo12.retobc.balance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.account.gateways.AccountGateway;

import reactor.core.publisher.Mono;

@Component
public class BalanceAdapter implements AccountGateway {

	@Autowired
	private WebClient webClient;
	
	@Override
	public Mono<AccountRS> getBalance() {		
		return webClient
                .post()
                .uri("https://young-tree-722.getsandbox.com:443/prueba")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AccountRS.class);
	}

	
	
}
