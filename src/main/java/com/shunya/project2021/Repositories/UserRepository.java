package com.shunya.project2021.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shunya.project2021.Models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);

	Optional<User> findById(Long id);
}
