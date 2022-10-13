package com.getir.readingisgood.api.handler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.getir.readingisgood.domain.dto.BaseApiResponse;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestErrorHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	public BaseApiResponse processNotFoundError(EntityNotFoundException ex) {
		logException(HttpStatus.NOT_FOUND, ex);
		return new BaseApiResponse(false, ex.getMessage());
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseApiResponse processValidationError(ValidationException ex) {
		logException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
		return new BaseApiResponse(false, ex.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public BaseApiResponse processMethodArgumentNotValidError(MethodArgumentNotValidException ex) {
		StringBuilder stringBuilder = new StringBuilder();
		logException(HttpStatus.INTERNAL_SERVER_ERROR, ex);
		return new BaseApiResponse(false, ex.getMessage());
	}
	private void logException(HttpStatus status, Exception ex) {
		String errorMessage = String.format("%s - %s : %s", status.name(), ex.getClass().getSimpleName(), ex.getMessage());
		log.error(errorMessage);
	}
	
}
