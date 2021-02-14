package com.equipo12.retobc.model.movement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
public class TransactionRS {

	private String id;
	private String postedDate;
	private String description;
	private int amount;
	private String type;
	private String reference1;
	private String reference2;
	private String reference3;
	private String checkNumber;
	private OfficeRS office;
	private RelatedTransferAccountRS relatedTransferAccount;
	private CustomerRS customer;
	
}
