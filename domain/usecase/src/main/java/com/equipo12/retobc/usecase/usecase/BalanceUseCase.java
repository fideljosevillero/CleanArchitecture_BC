package com.equipo12.retobc.usecase.usecase;

import com.equipo12.retobc.model.balance.RequestBalance;
import com.equipo12.retobc.model.balance.gateways.BalanceGateway;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BalanceUseCase {
	
	private BalanceGateway accountRQGateway;
	
	public Mono<RequestBalance> getBalanceUC(){
		return accountRQGateway.getBalance();
	}
	
}
