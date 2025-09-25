package com.example.Task_Management1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Task_Management1.domain.User;
import com.example.Task_Management1.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	private UserService userService;
	


    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
  
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
                                           @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }
    
    @GetMapping("/fetch")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/login-by-email")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
//        boolean isAuthenticated = userService.verifyEmailAndPassword(email, password);
//        User user=userService.verifyEmailAndPassword(email, password);
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful");
//        } else {
//            return ResponseEntity.status(401).body("Invalid email or password");
//        }
    	
    	User user=userService.verifyEmailAndPassword(email, password);
    	return ResponseEntity.ok().body(user);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
