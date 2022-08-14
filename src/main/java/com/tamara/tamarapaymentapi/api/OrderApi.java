package com.tamara.tamarapaymentapi.api;

import com.tamara.tamarapaymentapi.api.boundry.bo.OrderDTO;
import com.tamara.tamarapaymentapi.api.control.OrderService;
import com.tamara.tamarapaymentapi.api.entity.Order;
import com.tamara.tamarapaymentapi.api.boundry.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/order")
@Api(value = "Order EndPoints")
@Slf4j
public class OrderApi {

	private OrderService orderFacade;

	public OrderApi(OrderService orderFacade) {
		this.orderFacade = orderFacade;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = "Place new order", response = ResponseEntity.class)
	public ResponseEntity<?> placeOrder(@RequestBody @Valid @NotNull final OrderDTO orderDTO) {
		log.info("place new order");
		Long orderId = orderFacade.placeOrder(orderDTO);
		return ResponseUtil.wrapOrNotFound(orderId);
	}

	@RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
	@ApiOperation(value = "fetch order by order Id ", response = ResponseEntity.class)
	public ResponseEntity<?> getOrder(@NotNull @PathVariable final Long orderId) {
		log.info("retrieve order by order Id ");
		Order order = orderFacade.retrieveOrderById(orderId);
		return ResponseUtil.wrapOrNotFound(order);
	}

}
