package com.acp.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.acp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,String> {

	List<User> findAll();
	List<User> findByUsername(String username);
	
}
