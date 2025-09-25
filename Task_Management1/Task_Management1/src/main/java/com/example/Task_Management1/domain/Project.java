package com.example.Task_Management1.domain;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long proj_id;
	@Column(name = "proj_name", unique = true)
	private String proj_name;
	@Column(name = "proj_owner", nullable = false)
	private String proj_owner;
	@Column(name = "proj_created_date", nullable = false)
	private LocalDate proj_created_date;
	private String proj_description;
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"username", "email", "password", "project", "task"}) 
	private User user;
	@OneToMany(mappedBy = "project")
//	@JsonIgnoreProperties({"title", "email", "password", "project", "task"}) 
	private List<Task> task;
	public long getProj_id() {
		return proj_id;
	}
	public void setProj_id(long proj_id) {
		this.proj_id = proj_id;
	}
	public String getProj_name() {
		return proj_name;
	}
	public void setProj_name(String proj_name) {
		this.proj_name = proj_name;
	}
	public String getProj_owner() {
		return proj_owner;
	}
	public void setProj_owner(String proj_owner) {
		this.proj_owner = proj_owner;
	}
	public LocalDate getProj_created_date() {
		return proj_created_date;
	}
	public void setProj_created_date(LocalDate proj_created_date) {
		this.proj_created_date = proj_created_date;
	}
	public String getProj_description() {
		return proj_description;
	}
	public void setProj_description(String proj_description) {
		this.proj_description = proj_description;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Task> getTask() {
		return task;
	}
	public void setTask(List<Task> task) {
		this.task = task;
	}
	public void setProj_id(Long proj_id) {
		this.proj_id = proj_id;
	}

	
	
}
