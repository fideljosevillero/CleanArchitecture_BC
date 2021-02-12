package com.equipo12.retobc.model.account.balance;

import com.equipo12.retobc.model.account.balance.AccountRS.AccountRSBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class BalanceInformationRS {
	
	private String available;
	private String unavailableClearing;
	private String pockets;
	
}
