package com.example.excepiont_handeles.handler;

import com.example.excepiont_handeles.dto.ErrorDTO;
import com.example.excepiont_handeles.exception.ValorZeroExcpiontion;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ValorZerExcepitionHandler {
    @ResponseStatus(HttpStatus.PRECONDITION_FAILED)
    @ResponseBody
    @ExceptionHandler(ValorZeroExcpiontion.class)
    public ErrorDTO handler(ValorZeroExcpiontion ex){
        return new ErrorDTO(
                ex.getMessage(),
                ex.getLancamento()
        );
    }
}
