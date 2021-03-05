package com.equipo12.retobc.usecase.balanceandmovement;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

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
import com.equipo12.retobc.model.balanceandmovement.BalanceAndMovementRS;
import com.equipo12.retobc.model.movement.CustomerRS;
import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.MovementRS;
import com.equipo12.retobc.model.movement.OfficeRQ;
import com.equipo12.retobc.model.movement.OfficeRS;
import com.equipo12.retobc.model.movement.PaginationRQ;
import com.equipo12.retobc.model.movement.RelatedTransferAccountRS;
import com.equipo12.retobc.model.movement.TransactionRQ;
import com.equipo12.retobc.model.movement.TransactionRS;
import com.equipo12.retobc.model.movement.gateways.MovementGateway;
import com.equipo12.retobc.usecase.movementusecase.MovementUseCase;

import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
public class BalanceAndMovementUseCaseTest {

	@InjectMocks
	private MovementUseCase movementUseCase;

	@Mock
	private MovementGateway movementGateway;

	@Mock
	private BalanceGateway balanceGateway;

	@Mock
	private AccountRQ accountRQ;

	@Mock
	private MovementRQ movementRQ;

	private BalanceAndMovementUseCase balanceAndMovementUseCase;
	
	@Mock
	private BalanceAndMovementRS balanceAndMovementRS;

	@Before
	public void init() {
		movementRQ = MovementRQ.builder()
				.pagination(PaginationRQ.builder()
								.size(1)
								.key(2).build())
				.account(AccountRQ.builder()
							.type("CUENTA_DE_AHORRO")
							.number("406-700014-41").build())
				.transaction(TransactionRQ.builder()
								.startDate("17-08-2020")
								.endDate("17-08-2021")
								.minAmount("100000.0000")
								.maxAmount("1000000.0000")
								.type("DEBITO")
								.checkNumber("123456789010121314")
								.group("consignaciones")
								.description("Una descripción cualquiera").build())
				.office(OfficeRQ.builder()
							.code("0007")
							.name("Bancolombia").build())
				.build();
		
		MovementRS movementRS = MovementRS.builder()
				._responseSize(1)
				._flagMoreRecords("false")
				.transaction(List.of(
						TransactionRS.builder()
							.id("0007")
							.postedDate("17-08-2020")
							.description("Descripción cualquiera")
							.amount(2500)
							.type("DEBITO")
							.reference1("1104877855")
							.reference2("FAC987766")
							.reference3("FAC987766")
							.checkNumber("8975446757869098")
							.office(OfficeRS.builder()
										.code("0512345")
										.name("officeName").build())
							.relatedTransferAccount(RelatedTransferAccountRS.builder()
															.type("CUENTA_DE_AHORRO")
															.number("406-700014-41").build())
							.customer(CustomerRS.builder()
										.name("Fidel Jose Villero de Hoyos")
										.build())
						.build()
						)).build();
		
		RequestBalance requestBalance = RequestBalance.builder()
				.account(AccountRS.builder()
						.balances(BalancesRS.builder().available(1f).availableOverdraftBalance(2f).overdraftValue(4f)
								.availableOverdraftQuota(5f).cash(6f).unavailable_clearing(7f).receivable(8f)
								.blocked(9f).unavailableStartDay_clearingStartDay(10f).cashStartDay(11f).pockets(12f)
								.remittanceQuota(13f).agreedRemittanceQuota(14f).remittanceQuotaUsage(15f)
								.normalInterest(16f).suspensionInterest(17f).build())
						.build())
				.build();
		
									


		when(balanceAndMovementRS.getMovementRS()).thenReturn(movementRS);
		when(balanceAndMovementRS.getRequestBalance()).thenReturn(Mockito.any());
//		
		when(movementGateway.getMovement(movementRQ))
		.thenReturn(Mono.just(movementRS));
		when(balanceGateway.getBalance(movementRQ.getAccount()))
		.thenReturn(Mono.just(requestBalance));
//		when(balanceAndMovementUseCase.getBalanceAndMovement(movementRQ)).thenReturn(Mono.just(Mockito.any()));
	}

//	@Test
//	public void getBalanceAndMovementTest() {
//		assertNotNull(balanceAndMovementUseCase.getBalanceAndMovement(movementRQ));
//	}

}
