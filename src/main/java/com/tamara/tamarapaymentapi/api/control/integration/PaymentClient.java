package com.tamara.tamarapaymentapi.api.control.integration;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "crypto-client", url = "${payment.api.url}")
@Headers("Content-Type: application/json")
public interface PaymentClient {

	@RequestMapping(value = "/{orderId}", method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE, consumes =  MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity pay(@PathVariable("orderId") final Long orderId);
}
