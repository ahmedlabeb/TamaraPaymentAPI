package com.tamara.tamarapaymentapi.api.control;

import com.tamara.tamarapaymentapi.api.boundry.bo.OrderDTO;
import com.tamara.tamarapaymentapi.api.control.exception.ServiceError;
import com.tamara.tamarapaymentapi.api.entity.Order;
import com.tamara.tamarapaymentapi.api.entity.repositories.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderService {

	private OrderRepository orderRepository;

	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Long placeOrder(OrderDTO orderDTO){
		Order order = new Order();
		order.setDiscountAmount(orderDTO.getDiscountAmount());
		order.setTotalAmount(orderDTO.getTotalAmount());
		order.setTaxAmount(orderDTO.getTaxAmount());
		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

	public Order retrieveOrderById(Long orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if(order.isPresent()){
			return order.get();
		}
		throw ServiceError.ORDER_NOT_FOUND_ERROR.buildException();
	}
}
