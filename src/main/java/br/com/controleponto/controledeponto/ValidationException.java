package br.com.controleponto.controledeponto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidationException extends RuntimeException{
    private String message;
    private String status;
    private Integer code;

    public ValidationException(Integer code, String status, String message) {
        this.message = message;
        this.status = status;
        this.code = code;
    }

}
