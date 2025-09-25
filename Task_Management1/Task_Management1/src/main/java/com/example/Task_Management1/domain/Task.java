package com.example.Task_Management1.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(TaskId.class)
public class Task {
	
	@Id  //primary key
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Generated(value = { "" })
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    @Column(name="task_id", unique = true)
	private long task_id;
	@Id //primary key
	@Column(name = "task_no", unique = true)
	private String task_no;
	
	@Column(name = "title",  unique = true)
	private String title;
	
	@Column(name = "task_start_date")
	private LocalDate task_start_date;
	
	private LocalDate task_created_date;
	
	private LocalDate task_update_date;
	
	private LocalDate task_end_date;
	
	@Column(name = "task_status")
	private String task_status;
	
	@Column(name = "task_assigne")
	private String task_assigne;
	
	private String task_description;
	
	private String task_comments;
	
	@Column(name = "task_reported")
	private String task_reported;
	
	@ManyToOne
	@JoinColumn(name="proj_id")
	@JsonIgnoreProperties({"proj_owner","proj_created_date","proj_description", "task"}) 
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties({"username","email","password","project","task"})
	private User user;
	

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getTask_no() {
		return task_no;
	}

	public void setTask_no(String task_no) {
		this.task_no = task_no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getTask_start_date() {
		return task_start_date;
	}

	public void setTask_start_date(LocalDate task_start_date) {
		this.task_start_date = task_start_date;
	}

	public LocalDate getTask_created_date() {
		return task_created_date;
	}

	public void setTask_created_date(LocalDate task_created_date) {
		this.task_created_date = task_created_date;
	}

	public LocalDate getTask_update_date() {
		return task_update_date;
	}

	public void setTask_update_date(LocalDate task_update_date) {
		this.task_update_date = task_update_date;
	}

	public LocalDate getTask_end_date() {
		return task_end_date;
	}

	public void setTask_end_date(LocalDate task_end_date) {
		this.task_end_date = task_end_date;
	}

	public String getTask_status() {
		return task_status;
	}

	public void setTask_status(String task_status) {
		this.task_status = task_status;
	}

	public String getTask_assigne() {
		return task_assigne;
	}

	public void setTask_assigne(String task_assigne) {
		this.task_assigne = task_assigne;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getTask_comments() {
		return task_comments;
	}

	public void setTask_comments(String task_comments) {
		this.task_comments = task_comments;
	}

	public String getTask_reported() {
		return task_reported;
	}

	public void setTask_reported(String task_reported) {
		this.task_reported = task_reported;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setTask_id(Long task_id) {
		this.task_id = task_id;
	}



	
}
