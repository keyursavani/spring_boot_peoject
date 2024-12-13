package com.sport.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ApiResponseDTO {
	private int status;
	private String message;
	private Object body;

	public ApiResponseDTO(int status, String message, Object body) {
		super();
		this.status = status;
		this.message = message;
		this.body = body;
	}

	public ApiResponseDTO(int status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
}
