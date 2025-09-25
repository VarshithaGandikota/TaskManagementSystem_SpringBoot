package com.example.Task_Management1.domain;

public class TaskId {
	private long task_id;
	private String task_no;
	
	public TaskId() {
		
	}
	public TaskId(long task_id, String task_no) {
	
		this.task_id = task_id;
		this.task_no = task_no;
	}
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
	
}
