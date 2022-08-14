package com.tamara.tamarapaymentapi.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
@Getter
@Setter
public class Item {
	@Id
	private Long id;
	private String name;
	private String type;
	private String category;

}
