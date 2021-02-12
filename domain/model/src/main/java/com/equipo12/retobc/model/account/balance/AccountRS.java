package com.equipo12.retobc.model.account.balance;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccountRS {
//   private BalanceRS balances;
	private List<DataRS> data;

}
