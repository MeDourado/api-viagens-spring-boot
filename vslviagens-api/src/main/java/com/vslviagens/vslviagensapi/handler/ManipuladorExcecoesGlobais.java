package com.vslviagens.vslviagensapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vslviagens.vslviagensapi.exception.CampoVazioException;
import com.vslviagens.vslviagensapi.exception.RecursoExistenteException;
import com.vslviagens.vslviagensapi.exception.RecursoInvalidoException;
import com.vslviagens.vslviagensapi.exception.RecursoNaoEncontradoException;

@RestControllerAdvice
public class ManipuladorExcecoesGlobais {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<Object> handleRecursoNãoEncontradoException(RecursoNaoEncontradoException ex) {

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RecursoInvalidoException.class)
    public ResponseEntity<Object> handleRecursoInvalidoException(RecursoInvalidoException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(CampoVazioException.class)
    public ResponseEntity<Object> handleCampoVazioException(CampoVazioException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(RecursoExistenteException.class)
    public ResponseEntity<Object> handleRecursoExistenteException(RecursoExistenteException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
