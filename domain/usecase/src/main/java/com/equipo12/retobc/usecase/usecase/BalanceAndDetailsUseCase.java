package com.equipo12.retobc.usecase.usecase;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.account.gateways.AccountRQGateway;

import reactor.core.publisher.Flux;


public class BalanceAndDetailsUseCase {
	
	private AccountRQGateway accountRQGateway;
	
	public BalanceAndDetailsUseCase(AccountRQGateway accountRQGateway) {
		this.accountRQGateway = accountRQGateway;
	}
	
	public Flux<AccountRS> getBalanceAndMovement(){
		return accountRQGateway.getBalance();
	}
	
}
