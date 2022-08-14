package com.tamara.tamarapaymentapi.api.control.exception;

import org.springframework.http.HttpStatus;

public enum ServiceError implements RestError {
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "unexpected Error "),
	SERVICE_UN_AVAILABLE(HttpStatus.SERVICE_UNAVAILABLE, "Crypto Service is unavailable"),
	REQUEST_VALIDATION_ERROR(HttpStatus.BAD_REQUEST, "One or more inputs is not valid "),
	ORDER_NOT_FOUND_ERROR(HttpStatus.NOT_FOUND, "Order is not found"),
	UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Token is required"),
	USER_ALREADY_EXIST(HttpStatus.CONFLICT, "User Already exist");
	/**
	 * The http status.
	 */
	private HttpStatus httpStatus;
	/**
	 * The description.
	 */
	private String description;

	/**
	 * Instantiates a new Service errors.
	 *
	 * @param httpStatus  the http status
	 * @param description the description
	 */
	private ServiceError(final HttpStatus httpStatus, final String description) {
		this.httpStatus = httpStatus;
		this.description = description;
	}

	@Override
	public String error() {
		return this.name();
	}

	@Override
	public HttpStatus httpStatus() {
		return this.httpStatus;
	}

	@Override
	public String description() {
		return this.description;
	}

	public RestException buildException() {
		return new ServiceException(this);
	}
}
