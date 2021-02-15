package com.equipo12.retobc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.model.balance.gateways.BalanceGateway;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;
import com.equipo12.retobc.usecase.balanceandmovement.BalanceAndMovementUseCase;
import com.equipo12.retobc.usecase.balanceusecase.BalanceUseCase;
import com.equipo12.retobc.usecase.movement.MovementUseCase;

@Configuration
public class RestConsumerConfig {
	
    @Value("${adapter.restconsumer.url}")
    private String url;

    @Bean
    public BalanceUseCase balanceUseCase(BalanceGateway accountRQGateway) {
    	return new BalanceUseCase(accountRQGateway);
    }
    
    @Bean
    public MovementUseCase movementUseCase(MovementGateway movementGateway) {
    	return new MovementUseCase(movementGateway);
    }
    
    @Bean
    public BalanceAndMovementUseCase balanceAndMovementUseCase(BalanceGateway accountRQGateway, MovementGateway movementGateway) {
    	return new BalanceAndMovementUseCase(accountRQGateway, movementGateway);
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

}
