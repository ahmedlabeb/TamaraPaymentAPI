package com.tamara.tamarapaymentapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamara.tamarapaymentapi.api.boundry.bo.ItemDTO;
import com.tamara.tamarapaymentapi.api.boundry.bo.OrderDTO;
import com.tamara.tamarapaymentapi.api.control.RegistrationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderApiTest {
	@MockBean
	RegistrationService registrationService;

	private final ObjectMapper mapper = new ObjectMapper();

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	@Test
	void testPlaceOrderInvalidBody() throws Exception {
		mockMvc.perform(post("/api/order")
						.content(mapper.writeValueAsString(buildOrderDtoWithoutFields()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	void testPlaceOrder() throws Exception {
		mockMvc.perform(post("/api/order")
						.content(mapper.writeValueAsString(buildOrderDtoWithoutFields()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	private OrderDTO buildOrderDtoWithoutFields() {
		return new OrderDTO();
	}
	private OrderDTO buildOrderDto() {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setTotalAmount(new BigDecimal(10));
		orderDTO.setItems(List.of(new ItemDTO("item1","type1","category1")));
		return orderDTO;

	}
}
