package com.equipo12.retobc.usecase.movement;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equipo12.retobc.model.balance.AccountRQ;
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

import reactor.core.publisher.Mono;

@RunWith(SpringJUnit4ClassRunner.class)
public class MovementUseCaseTest {

	@InjectMocks
	private MovementUseCaseTest movementUseCase;
	
	@Mock
	private MovementGateway movementGateway;
	
	@Mock
	private MovementRQ movementRQ;
	
	@Before
    public void init(){
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
		
        when(movementGateway.getMovement(movementRQ)).thenReturn(Mono.just(movementRS));

    }
	
	@Test
    public void testGetMovememtUC(){

        Mono<MovementRS> res = movementGateway.getMovement(movementRQ);
        assertNotNull(res);

    }
	
}
