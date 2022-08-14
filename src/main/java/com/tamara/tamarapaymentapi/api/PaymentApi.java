package com.tamara.tamarapaymentapi.api;

import com.tamara.tamarapaymentapi.api.control.PaymentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api")
@Api(value = "payment EndPoint")
@Slf4j
public class PaymentApi {

	private PaymentService paymentService;

	public PaymentApi(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@RequestMapping(value = "/pay", method = RequestMethod.POST)
	@ApiOperation(value = "pay the order", response = ResponseEntity.class)
	public ResponseEntity<?> payOrder(@NotNull @PathVariable final Long orderId) {
		log.info("pay the order");
		paymentService.payOrder(orderId);
		return ResponseEntity.ok().build();
	}
}
