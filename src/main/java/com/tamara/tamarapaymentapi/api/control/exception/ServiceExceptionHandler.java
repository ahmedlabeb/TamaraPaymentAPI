package com.tamara.tamarapaymentapi.api.control.exception;

import feign.FeignException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {
	/**
	 * Handle exception.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(ServiceException.class)
	public final ResponseEntity<ServiceErrorResponse> handleException(final RestException exception) {
		final RestError restError = exception.getRestError();
		final ServiceErrorResponse errorResponse = ServiceErrorResponse.builder().errorMessage(restError.description())
				.error(restError.error()).status(restError.httpStatus().name()).build();
		return new ResponseEntity<>(errorResponse, restError.httpStatus());
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ServiceErrorResponse> handleAllException(final Exception ex, final WebRequest request) {
		ex.printStackTrace();
		final ServiceError serviceError = ServiceError.INTERNAL_SERVER_ERROR;
		final ServiceErrorResponse errorDetails = new ServiceErrorResponse(ex.getMessage(), serviceError.toString(),
				serviceError.httpStatus().toString(), LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
		return new ResponseEntity<>(errorDetails, serviceError.httpStatus());
	}

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<Object> handleFeignException(final FeignException fe) {
		final ServiceError cryptoServiceError =  ServiceError.SERVICE_UN_AVAILABLE;
		final ServiceErrorResponse errorDetails = new ServiceErrorResponse(fe.getMessage(), cryptoServiceError.toString(),
				cryptoServiceError.httpStatus().toString(), LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
		return new ResponseEntity<Object>(errorDetails, cryptoServiceError.httpStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex,
																  final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
		final ServiceError serviceError = ServiceError.REQUEST_VALIDATION_ERROR;
		final ServiceErrorResponse errorDetails = new ServiceErrorResponse(ex.getMessage(), serviceError.toString(),
				serviceError.httpStatus().toString(), LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
		return new ResponseEntity<>(errorDetails, serviceError.httpStatus());
	}

}
