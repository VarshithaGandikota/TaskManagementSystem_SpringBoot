package com.example.Task_Management1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Task_Management1.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
//	 User findByUsername(String username);
	  User findByEmail(String email);
	  
	    Optional<User> findByEmailAndPassword(String email, String password);
}
