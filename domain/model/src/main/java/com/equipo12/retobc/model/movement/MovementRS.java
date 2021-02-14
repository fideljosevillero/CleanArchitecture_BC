package com.equipo12.retobc.model.movement;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MovementRS {
	private int _responseSize;
	private String _flagMoreRecords;
	private List<TransactionRS> transaction;
}
