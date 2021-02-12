package com.equipo12.retobc.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.account.gateways.AccountRQGateway;

import reactor.core.publisher.Mono;

@Component
public class BalanceAdapter implements AccountRQGateway {

	@Autowired
	private WebClient webClient;
	
	@Override
	public Mono<AccountRS> getBalance() {
//		return Mono.just(AccountRS.builder()
//							.balances(
//									BalanceRS.builder()
//										.available(1f)
//										.availableOverdraftBalance(2f)
//										.overdraftValue(3f)
//										.availableOverdraftQuota(4f)
//										.cash(5f)
//										.unavailable_clearing(6f)
//										.receivable(7f)
//										.blocked(8f)
//										.unavailableStartDay_clearingStartDay(9f)
//										.cashStartDay(10f)
//										.pockets(11f)
//										.remittanceQuota(12f)
//										.agreedRemittanceQuota(13f)
//										.remittanceQuotaUsage(14f)
//										.normalInterest(15f)
//										.suspensionInterest(16f)
//										.build()
//									).build());
		
		return webClient
                .post()
                .uri("https://young-tree-722.getsandbox.com:443/prueba")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AccountRS.class);
	}

	
	
}
