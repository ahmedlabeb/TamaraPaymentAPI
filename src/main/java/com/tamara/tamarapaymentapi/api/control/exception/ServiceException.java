package com.tamara.tamarapaymentapi.api.control.exception;

import lombok.Getter;

@Getter
public class ServiceException extends RestException{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3102904573968573206L;

	/** The Rest Service errors. */
	private RestError restError;

	/**
	 * Instantiates a new OrderService exception.
	 *
	 * @param RestError the RestError error
	 */
	public ServiceException(final RestError restError) {
		super(restError);
		this.restError = restError;
	}
}
