package com.example.Task_Management1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task_Management1.domain.User;
import com.example.Task_Management1.exception.EmailAlreadyExistsException;
import com.example.Task_Management1.exception.EmailNotFoundException;
import com.example.Task_Management1.exception.ResourceNotFoundException;
import com.example.Task_Management1.repository.UserRepository;


@Service
public class UserService {
	@Autowired
   private UserRepository userRepository;

	  public User createUser(User user) {
	        if (userRepository.findByEmail(user.getEmail()) != null) {
	            throw new EmailAlreadyExistsException("Email already exists: " + user.getEmail());
	        }
	        return userRepository.save(user);
	    }
	
    
	  public User updateUser(long id, User userDetails) {
	        User user = getUserById(id);

	        if (!user.getEmail().equals(userDetails.getEmail()) &&
	            userRepository.findByEmail(userDetails.getEmail()) != null) {
	            throw new EmailAlreadyExistsException("Email already exists: " + userDetails.getEmail());
	        }

	        user.setUsername(userDetails.getUsername());
	        user.setEmail(userDetails.getEmail());
	        user.setPassword(userDetails.getPassword());

	        return userRepository.save(user);
	    }
	  
	  public User getUserById(long id) {
	        return userRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
	    }

	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
	    public User verifyEmailAndPassword(String email, String password) {
	    	
	    	return userRepository.findByEmailAndPassword(email, password).orElseThrow(()-> new EmailNotFoundException("email not found"+email));
//	        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
//	         if(user.isPresent()) {
//	        	 return userRepository.findByEmail(email);// Return true if user exists, otherwise false
//	         }
	         
	    }
	    
	    public void deleteUser(long id) {
	        User user = getUserById(id);
	        userRepository.delete(user);
	    }
	    
    
}
