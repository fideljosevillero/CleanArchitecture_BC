package com.equipo12.retobc.model.commons;

import lombok.Getter;

public class BalanceAndMovementException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    @Getter
    private String code;

    public BalanceAndMovementException(String message) {
        super(message);
    }

    public BalanceAndMovementException(String message, String code) {
        super(message);
        this.code = code;
    }

}
