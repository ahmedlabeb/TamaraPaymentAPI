package com.tamara.tamarapaymentapi.api.boundry.bo;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	@NotNull
	private String name;
	@NotNull
	private String type;
	@NotNull
	private String category;
}
