package com.equipo12.retobc.model.balance.gateways;

import com.equipo12.retobc.model.balance.AccountRQ;
import com.equipo12.retobc.model.balance.RequestBalance;

import reactor.core.publisher.Mono;

public interface BalanceGateway {

   public Mono<RequestBalance> getBalance(AccountRQ accountRQ);
   
}
