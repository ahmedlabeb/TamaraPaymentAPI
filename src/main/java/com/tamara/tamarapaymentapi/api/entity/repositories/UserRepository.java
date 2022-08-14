package com.tamara.tamarapaymentapi.api.entity.repositories;

import com.tamara.tamarapaymentapi.api.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
	Optional<User> findByName(String name);
}
