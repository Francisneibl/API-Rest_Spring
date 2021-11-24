package com.anhanguera.projeto.api.exceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.anhanguera.projeto.domain.exception.BusinessException;
import com.anhanguera.projeto.domain.exception.EntidadeNotFoundException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<Problem.Field> campos = new ArrayList<>();
		
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new Problem.Field(nome, mensagem));
		}
		
		Problem problema = new Problem();
		problema.setStatus(status.value());
		problema.setDateHour(OffsetDateTime.now());
		problema.setTitle("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
		problema.setFields(campos);
		
		return handleExceptionInternal(ex, problema, headers, status, request);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(BusinessException.class)
	public ResponseEntity<Object> handleBusiness(BusinessException ex, WebRequest request){
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		Problem problem = new Problem();
		
		problem.setStatus(status.value());
		problem.setDateHour(OffsetDateTime.now());
		problem.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler(EntidadeNotFoundException.class)
	public ResponseEntity<Object> handleEntidadeNotFound(EntidadeNotFoundException ex, WebRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		Problem problem = new Problem();
			
		problem.setStatus(status.value());
		problem.setDateHour(OffsetDateTime.now());
		problem.setTitle(ex.getMessage());
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}
}
