package com.equipo12.retobc.usecase.movementTest;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equipo12.retobc.model.balance.AccountRQ;
import com.equipo12.retobc.model.balance.AccountRS;
import com.equipo12.retobc.model.balance.BalancesRS;
import com.equipo12.retobc.model.balance.RequestBalance;
import com.equipo12.retobc.model.balance.gateways.BalanceGateway;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;
import com.equipo12.retobc.usecase.movement.MovementUseCaseTest;

import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
public class BalanceUseCaseTest {

	@InjectMocks
	private MovementUseCaseTest movementUseCase;

	@Mock
	private MovementGateway movementGateway;

	@Mock
	private BalanceGateway balanceGateway;

	@Mock
	private AccountRQ accountRQ;

	@Before
	public void init() {
		accountRQ = AccountRQ.builder().type("CUENTA_DE_AHORRO").number("406-700014-41").build();

		RequestBalance requestBalance = RequestBalance.builder()
				.account(AccountRS.builder()
						.balances(BalancesRS.builder().available(1f).availableOverdraftBalance(2f).overdraftValue(4f)
								.availableOverdraftQuota(5f).cash(6f).unavailable_clearing(7f).receivable(8f)
								.blocked(9f).unavailableStartDay_clearingStartDay(10f).cashStartDay(11f).pockets(12f)
								.remittanceQuota(13f).agreedRemittanceQuota(14f).remittanceQuotaUsage(15f)
								.normalInterest(16f).suspensionInterest(17f).build())
						.build())
				.build();

		when(balanceGateway.getBalance(Mockito.any())).thenReturn(Mono.just(requestBalance));

	}

	@Test
	public void getBalanceUCTest() {
		Mono<RequestBalance> res = balanceGateway.getBalance(accountRQ);
		assertNotNull(res);
	}

}
