package com.equipo12.retobc.model.movement;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
@NoArgsConstructor
public class RelatedTransferAccountRS {

	private String type;
	private String number;
	
}
