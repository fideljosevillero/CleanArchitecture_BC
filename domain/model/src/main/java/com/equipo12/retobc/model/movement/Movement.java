package com.equipo12.retobc.model.movement;
import java.util.List;

import com.equipo12.retobc.model.account.balance.DataRS;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Movement {
	private String respuesta;
}
