package com.tamara.tamarapaymentapi.api.entity.repositories;

import com.tamara.tamarapaymentapi.api.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
