package com.equipo12.retobc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.account.gateways.AccountGateway;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;
import com.equipo12.retobc.usecase.movement.MovementUseCase;
import com.equipo12.retobc.usecase.usecase.BalanceUseCase;

@Configuration
public class RestConsumerConfig {
	
    @Value("${adapter.restconsumer.url}")
    private String url;

    @Bean
    public BalanceUseCase balanceUseCase(AccountGateway accountRQGateway) {
    	return new BalanceUseCase(accountRQGateway);
    }
    
    @Bean
    public MovementUseCase movementUseCase(MovementGateway movementGateway) {
    	return new MovementUseCase(movementGateway);
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

}
