package com.equipo12.retobc.usecase.usecase;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.account.gateways.AccountGateway;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Mono;

@AllArgsConstructor
public class BalanceUseCase {
	
	private AccountGateway accountRQGateway;
	
	public Mono<AccountRS> getBalanceUC(){
		return accountRQGateway.getBalance();
	}
	
}
