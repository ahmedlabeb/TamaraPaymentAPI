package com.tamara.tamarapaymentapi.api.control.exception;

import org.springframework.http.HttpStatus;

public interface RestError {

	String error();

	HttpStatus httpStatus();

	String description();
}
