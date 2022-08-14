package com.tamara.tamarapaymentapi.api.boundry.bo;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
	@NotNull
	@NotBlank
	@Positive
	private BigDecimal totalAmount;
	@Positive
	private BigDecimal taxAmount;
	@Positive
	private BigDecimal discountAmount;

	private List<ItemDTO> items;

}
