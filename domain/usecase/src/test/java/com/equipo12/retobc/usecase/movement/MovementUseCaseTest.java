package com.equipo12.retobc.usecase.movement;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.equipo12.retobc.model.balance.AccountRQ;
import com.equipo12.retobc.model.movement.MovementRQ;
import com.equipo12.retobc.model.movement.MovementRS;
import com.equipo12.retobc.model.movement.OfficeRQ;
import com.equipo12.retobc.model.movement.PaginationRQ;
import com.equipo12.retobc.model.movement.TransactionRQ;
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
		
//		MovementRS movementRS = MovementRS.builder()
//											._responseSize(1)
//											._flagMoreRecords("false")
//											.transaction()
//									
//						
//        when(movementGateway.getMovement(movementRQ)).thenReturn(Mono.just(rechargeResponse));

    }
	
	@Test
    public void testGetMovememtUC(){

        Mono<MovementRS> res = movementGateway.getMovement(movementRQ);
        assertNotNull(res);
        res.subscribe();

    }
	
}
