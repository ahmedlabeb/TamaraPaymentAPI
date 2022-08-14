package com.tamara.tamarapaymentapi.api.boundry.bo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Api
public class UserDTO {
	@NotNull
	@ApiModelProperty("name")
	@JsonProperty("name")
	private String name;

	@NotNull
	@ApiModelProperty("password")
	@JsonProperty("password")
	private String password;

}
