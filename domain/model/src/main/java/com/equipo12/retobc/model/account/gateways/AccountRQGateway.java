package com.equipo12.retobc.model.account.gateways;

import com.equipo12.retobc.model.account.balance.AccountRS;
import reactor.core.publisher.Flux;

public interface AccountRQGateway {

   public Flux<AccountRS> getBalance();
}
