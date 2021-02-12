package com.equipo12.retobc.consumer;

import com.equipo12.retobc.model.account.balance.AccountRS;
import com.equipo12.retobc.model.account.balance.BalanceRS;
import com.equipo12.retobc.model.account.gateways.AccountRQGateway;

import reactor.core.publisher.Flux;

public class BalanceAdapter implements AccountRQGateway {

	@Override
	public Flux<AccountRS> getBalance() {
		return Flux.just(AccountRS.builder()
							.balances(
									BalanceRS.builder()
										.available(1f)
										.availableOverdraftBalance(2f)
										.overdraftValue(3f)
										.availableOverdraftQuota(4f)
										.cash(5f)
										.unavailable_clearing(6f)
										.receivable(7f)
										.blocked(8f)
										.unavailableStartDay_clearingStartDay(9f)
										.cashStartDay(10f)
										.pockets(11f)
										.remittanceQuota(12f)
										.agreedRemittanceQuota(13f)
										.remittanceQuotaUsage(14f)
										.normalInterest(15f)
										.suspensionInterest(16f)
										.build()
									).build());
	}

	
	
}
