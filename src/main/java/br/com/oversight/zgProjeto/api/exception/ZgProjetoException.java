package br.com.oversight.zgProjeto.api.exception;

import java.io.Serializable;
import java.nio.file.AccessDeniedException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ZgProjetoException extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler({ EmptyResultDataAccessException.class })
	public ResponseEntity errorNotFound() {
		return ResponseEntity.notFound().build();
	}

	@ExceptionHandler({ IllegalArgumentException.class })
	public ResponseEntity errorBadRequest() {
		return ResponseEntity.badRequest().build();
	}

	@ExceptionHandler({ AccessDeniedException.class })
	public ResponseEntity accessDenied() {
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new Error("Acesso negado"));
	}
	
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ExceptionError("Operação não permitida"), HttpStatus.METHOD_NOT_ALLOWED);
    }
}

class ExceptionError implements Serializable {
    private String error;
    ExceptionError(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }
}
