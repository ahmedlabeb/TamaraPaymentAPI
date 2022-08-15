package com.tamara.tamarapaymentapi.api.control;

import com.tamara.tamarapaymentapi.api.control.exception.ServiceException;
import com.tamara.tamarapaymentapi.api.entity.Order;
import com.tamara.tamarapaymentapi.api.entity.repositories.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderServiceTest {

	private OrderService orderService;

	@Autowired
	private OrderRepository orderRepository;

	@BeforeEach
	public void setUp() {
		orderService = new OrderService(orderRepository);
		orderRepository.saveAll(prepareDummyOrders());
	}

	@Test
	void findOrder_NotFound() {
		assertThrows(ServiceException.class,
				() -> orderService.retrieveOrderById(12345l));
	}

	@Test
	void retrieveOrderById_NotFound() {
		assertThrows(ServiceException.class,
				() -> orderService.retrieveOrderById(12345l));
	}
	@Test
	void retrieveOrderbyId_sucess(){
		Order order = orderService.retrieveOrderById(1l);
		assertNotNull(order);
		assertEquals(new BigDecimal(10), order.getTaxAmount());
		assertEquals(new BigDecimal(100), order.getTotalAmount());
	}
	private List<Order> prepareDummyOrders() {

		Order order1=new Order();
		order1.setId(1l);
		order1.setTotalAmount(new BigDecimal(100));
		order1.setTaxAmount(new BigDecimal(10));

		Order order2=new Order();
		order2.setId(2l);
		order2.setTotalAmount(new BigDecimal(200));
		order2.setTaxAmount(new BigDecimal(20));
		order2.setDiscountAmount(new BigDecimal(5));
		return List.of(order1,order2);
	}
}
