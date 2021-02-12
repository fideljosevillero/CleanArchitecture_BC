package com.equipo12.retobc.model.account.gateways;

import com.equipo12.retobc.model.account.balance.AccountRS;

import reactor.core.publisher.Mono;

public interface AccountRQGateway {

   public Mono<AccountRS> getBalance();
}
