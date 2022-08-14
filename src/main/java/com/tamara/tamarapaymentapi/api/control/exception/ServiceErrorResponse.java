package com.tamara.tamarapaymentapi.api.control.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ServiceErrorResponse {
	/** The error message . */
	private String errorMessage;

	/** The error Code . */
	private String error;

	/** The status. */
	private String status;
	/**
	 * Request time Stamp
	 */
	private Long timestamp;
}
