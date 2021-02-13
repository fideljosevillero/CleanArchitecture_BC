package com.equipo12.retobc.model.movement;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Movement {
	private String respuesta;
}
