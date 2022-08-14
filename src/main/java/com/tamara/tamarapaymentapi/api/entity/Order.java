package com.tamara.tamarapaymentapi.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order")
@Getter
@Setter
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private BigDecimal totalAmount;
	private BigDecimal taxAmount;
	private BigDecimal discountAmount;
	@ManyToMany
	private Set<Item> items;
}
