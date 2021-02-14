package com.equipo12.retobc.model.movement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRQ {

	private String startDate;
	private String endDate;
	private String minAmount;
	private String maxAmount;
	private String type;
	private String checkNumber;
	private String group;
	private String description;
	
}
