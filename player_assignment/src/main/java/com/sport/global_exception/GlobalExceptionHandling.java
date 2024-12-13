package com.sport.global_exception;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sport.custome_exception.PlayerException;
import com.sport.dto.ApiResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandling {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("in method arg invalid " + e);
		List<FieldError> fieldErrors = e.getFieldErrors();
		Map<String, String> map = fieldErrors.stream()
				.collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}

	@ExceptionHandler(PlayerException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ResponseEntity<?> handleResourceNotFoundException(PlayerException e) {
		System.out.println("in player not found " + e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ApiResponseDTO(HttpStatus.NOT_FOUND.value(), e.getMessage()));
	}

//	@ExceptionHandler(AuthenticationException.class)
//	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
//	public ApiResponse handleAuthenticationException(AuthenticationException e) {
//		System.out.println("in authentication exception " + e);
//		return new ApiResponse(e.getMessage());
//	}

//	@ExceptionHandler(AccessDeniedException.class)
//	@ResponseStatus(value = HttpStatus.FORBIDDEN)
//	public ApiResponse handleAccessDeniedException(AccessDeniedException e) {
//		System.out.println("in access denied  exception " + e);
//		return new ApiResponse(e.getMessage());
//	}

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<?> handleAnyException(RuntimeException e) {
		System.out.println("in catch-all " + e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
	}

}
