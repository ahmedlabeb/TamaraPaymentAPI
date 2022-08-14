package com.tamara.tamarapaymentapi.api;

import com.tamara.tamarapaymentapi.api.boundry.bo.UserDTO;
import com.tamara.tamarapaymentapi.api.entity.User;
import com.tamara.tamarapaymentapi.api.control.RegistrationService;
import com.tamara.tamarapaymentapi.api.boundry.utils.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/user")
@Api(value = "user EndPoint")
@Slf4j
public class UserApi {

	private RegistrationService registerationService;

	public UserApi(RegistrationService registerationService) {
		this.registerationService = registerationService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ApiOperation(value = "Register User ", response = ResponseEntity.class)
	public ResponseEntity<?> register(@RequestBody @Valid @NotNull UserDTO userDTO) {
		log.info("User Registeration");
		User user = registerationService.registerUser(userDTO);
		return ResponseUtil.wrapOrNotFound(user);
	}

}
