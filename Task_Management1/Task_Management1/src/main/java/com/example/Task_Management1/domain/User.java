package com.example.Task_Management1.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	@Column(name = "username")
	private String username;
	@Column(name = "email",unique = true)
	private String email;

	private String password;
	
	// mapping
	@OneToMany(mappedBy = "user")
	private List<Project> project;
	@OneToMany(mappedBy = "user")
	 
	private List<Task> task;
//	public long getUser_id() {
//		return user_id;
//	}
//	public void setUser_id(long user_id) {
//		this.user_id = user_id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public List<Project> getProject() {
//		return project;
//	}
//	public void setProject(List<Project> project) {
//		this.project = project;
//	}
//	public List<Task> getTask() {
//		return task;
//	}
//	public void setTask(List<Task> task) {
//		this.task = task;
//	}
	
}
