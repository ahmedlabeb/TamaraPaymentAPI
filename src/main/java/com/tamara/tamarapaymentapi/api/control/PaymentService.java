package com.tamara.tamarapaymentapi.api.control;

import com.tamara.tamarapaymentapi.api.control.integration.PaymentClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	private PaymentClient paymentClient;

	public PaymentService(PaymentClient paymentClient) {
		this.paymentClient = paymentClient;
	}

	public void payOrder(Long orderId){
		paymentClient.pay(orderId);
	}
}
