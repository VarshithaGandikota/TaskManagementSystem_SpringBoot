package com.example.Task_Management1.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Task_Management1.domain.Project;
import com.example.Task_Management1.domain.Task;
import com.example.Task_Management1.domain.TaskId;
import com.example.Task_Management1.domain.User;
import com.example.Task_Management1.exception.NameAlreadyExistsException;
import com.example.Task_Management1.exception.ResourceNotFoundException;
import com.example.Task_Management1.repository.ProjectRepository;
import com.example.Task_Management1.repository.TaskRepository;
import com.example.Task_Management1.repository.UserRepository;

@Service
public class TaskService {

	
	@Autowired
	private TaskRepository taskRepository;
	
	
	 @Autowired
	    private UserRepository userRepository;
	 
	 @Autowired
	    private ProjectRepository projectRepository;

	
//	 public Task createTask(Task task) {
//	        if (taskRepository.findByTask_no(task.getTask_no()) == null) {
//	            throw new NameAlreadyExistsException("Task number already exists: " + task.getTask_no());
//	        }
//	        return taskRepository.save(task);
//	    }
	 
	   public Task saveTask(Task task, Long projId, Long userId) {
		   // Check if the project exists
	        Project project = projectRepository.findById(projId)
	            .orElseThrow(() -> new RuntimeException("Project not found"));

	        // Check if the user exists
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new RuntimeException("User not found"));

	        // Check if the user is the owner of the project
	        if (!project.getUser().getUser_id().equals(userId)) {
	            throw new RuntimeException("User is not authorized for this project");
	        }

	        // Set the project and user to the task
	        task.setProject(project);
	        task.setUser(user);

	        // Save the task
	        return taskRepository.save(task);
	    }
	    
	
//	  public Task updateTask(TaskId id, Task taskDetails) {
//	        if (taskRepository.existsById(id)) {
//	        	Task task=taskRepository.findByTask(taskDetails.getTask_no());
//				task.setTitle(taskDetails.getTitle());
//	   	        task.setTask_start_date(taskDetails.getTask_start_date());
//	   	        task.setTask_update_date(taskDetails.getTask_update_date());
//	   	        task.setTask_end_date(taskDetails.getTask_end_date());
//	   	        task.setTask_status(taskDetails.getTask_status());
//	   	        task.setTask_assigne(taskDetails.getTask_assigne());
//	   	        task.setTask_description(taskDetails.getTask_description());
//	   	        task.setTask_comments(taskDetails.getTask_comments());
//	   	        task.setTask_reported(taskDetails.getTask_reported());
//	            return taskRepository.save(taskDetails);
//	        } else {
//	            throw new ResourceNotFoundException("Task not found with id " + id);
//	        }
//	    }
	 
	
	  
	 
//	 public Task updateTaskByTaskNo(String task_no, Task taskDetails) {
//	        Task task = taskRepository.findByTask_no(task_no)
//	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with task_no: " + task_no));
//
//	        // Update the fields
//	        task.setTitle(taskDetails.getTitle());
//	        task.setTask_start_date(taskDetails.getTask_start_date());
//	        task.setTask_update_date(taskDetails.getTask_update_date());
//	        task.setTask_end_date(taskDetails.getTask_end_date());
//	        task.setTask_status(taskDetails.getTask_status());
//	        task.setTask_assigne(taskDetails.getTask_assigne());
//	        task.setTask_description(taskDetails.getTask_description());
//	        task.setTask_comments(taskDetails.getTask_comments());
//	        task.setTask_reported(taskDetails.getTask_reported());
//	        
//	        return taskRepository.save(task);
//	    }
	  public Optional<Task> getTaskById(TaskId id) {
	        return Optional.of(taskRepository.findById(id)
	        		.orElseThrow(() -> new ResourceNotFoundException("TaskId not found with id: " + id)));
	    }
	  
	   public Task getTaskByTaskNo(String task_no) {
	        return taskRepository.findByTask_no(task_no)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with task_no: " + task_no));
	    }
	  
	  public List<Task> getAllTasks() {
	        return taskRepository.findAll();
	    }
	  
	  public void deleteTask(TaskId id) {
	        if (taskRepository.existsById(id)) {
	            taskRepository.deleteById(id);
	        } else {
	            throw new ResourceNotFoundException("Task not found with id " + id);
	        }
	    }
	  
	  
	    public void deleteTaskByTaskNo(String task_no) {
	        Task task = taskRepository.findByTask_no(task_no)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with task_no: " + task_no));
	        taskRepository.delete(task);
	    }
	    
	    
	    public List<Task> getTasksByProjectId(long projId) {
	        return taskRepository.findByProject_ProjId(projId);
	    }
	    
//	    public Optional<Task> getTaskByIdAndNo(long taskId, String taskNo) {
//	        return taskRepository.findByTaskIdAndTaskNo(taskId, taskNo);
//	    }

	    public Task updateTask(long taskId, String taskNo, Task taskDetails) {
	        Task task = taskRepository.findByTaskIdAndTaskNo(taskId, taskNo)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId + " and taskNo " + taskNo));

	        task.setTitle(taskDetails.getTitle());
	        task.setTask_start_date(taskDetails.getTask_start_date());
	        task.setTask_end_date(taskDetails.getTask_end_date());
	        task.setTask_status(taskDetails.getTask_status());
	        task.setTask_assigne(taskDetails.getTask_assigne());
	        task.setTask_description(taskDetails.getTask_description());
	        task.setTask_comments(taskDetails.getTask_comments());
	        task.setTask_reported(taskDetails.getTask_reported());
	        task.setTask_update_date(LocalDate.now());

	        return taskRepository.save(task);
	    }
	    
	    
	    
	    
	
}



