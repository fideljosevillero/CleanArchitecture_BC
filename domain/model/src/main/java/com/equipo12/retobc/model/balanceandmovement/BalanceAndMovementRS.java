package com.equipo12.retobc.model.balanceandmovement;

import com.equipo12.retobc.model.balance.RequestBalance;
import com.equipo12.retobc.model.movement.MovementRS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BalanceAndMovementRS {

	private RequestBalance requestBalance;
	private MovementRS movementRS;
	
}
