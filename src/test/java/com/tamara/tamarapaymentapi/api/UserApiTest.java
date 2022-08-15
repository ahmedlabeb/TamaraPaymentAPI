package com.tamara.tamarapaymentapi.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tamara.tamarapaymentapi.api.boundry.bo.UserDTO;
import com.tamara.tamarapaymentapi.api.control.RegistrationService;
import com.tamara.tamarapaymentapi.api.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserApiTest {

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
	void testRegister() throws Exception {
		Mockito.lenient().when(registrationService.registerUser(any())).thenReturn(buildUser());
		mockMvc.perform(post("/api/user/register")
						.content(mapper.writeValueAsString(buildUserDto()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	}


	@Test
	void testRegisterWithoutBody() throws Exception {
		mockMvc.perform(post("/api/user/register")
						.content(mapper.writeValueAsString(buildUserDtoWithoutFields()))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	private UserDTO buildUserDto(){
		UserDTO userDTO=new UserDTO();
		userDTO.setName("ahmed");
		userDTO.setPassword("123");
		return userDTO;
	}
	private UserDTO buildUserDtoWithoutFields(){
		UserDTO userDTO=new UserDTO();
		return userDTO;
	}

	private User buildUser(){
		User user=new User();
		user.setName("ahmed");
		user.setPassword("123");
		return user;
	}
}
