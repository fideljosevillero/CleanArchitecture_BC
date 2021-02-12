package com.equipo12.retobc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

import com.equipo12.retobc.consumer.BalanceAdapter;
import com.equipo12.retobc.model.account.gateways.AccountRQGateway;
import com.equipo12.retobc.usecase.usecase.BalanceAndDetailsUseCase;

@Configuration
public class RestConsumerConfig {
	
    @Value("${adapter.restconsumer.url}")
    private String url;

    @Bean
    public BalanceAndDetailsUseCase balanceAndDetailsUseCase(AccountRQGateway accountRQGateway) {
    	return new BalanceAndDetailsUseCase(accountRQGateway);
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
            .baseUrl(url)
            .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/json")
            .build();
    }

}
