package com.example.Task_Management1.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.Task_Management1.domain.Project;
import com.example.Task_Management1.domain.Task;
import com.example.Task_Management1.domain.TaskId;
import com.example.Task_Management1.domain.TaskRequest;
import com.example.Task_Management1.exception.ResourceNotFoundException;
import com.example.Task_Management1.service.TaskService;

@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {

	
	@Autowired
	private TaskService taskService;
	

//    @PostMapping("/add")
//    public Task createTask(@RequestBody Task task) {
//        return taskService.createTask(task);
//    }
    
    @PostMapping
    public Task createTask1(@RequestBody TaskRequest taskRequest) {
        return taskService.saveTask(taskRequest.getTask(), taskRequest.getProjId(), taskRequest.getUserId());
    }

    @GetMapping("/{task_id}/{task_no}")
    public ResponseEntity<Optional<Task>> getTaskById(@PathVariable("task_id") long taskId, @PathVariable("task_no") String taskNo) {
        TaskId id = new TaskId(taskId, taskNo);
        Optional<Task> task = taskService.getTaskById(id);
        return ResponseEntity.ok().body(task);
    }
    
    @GetMapping("/taskNo/{task_no}")
    public ResponseEntity<Task> getTaskByTaskNo(@PathVariable String task_no) {
        Task task = taskService.getTaskByTaskNo(task_no);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/allTask")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    
    @DeleteMapping("/{task_id}/{task_no}")
    public ResponseEntity<Void> deleteTask(@PathVariable("task_id") long taskId, @PathVariable("task_no") String taskNo) {
        TaskId id = new TaskId(taskId, taskNo);
        try {
            taskService.deleteTask(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/taskNo/{task_no}")
    public ResponseEntity<Void> deleteTaskByTaskNo(@PathVariable String task_no) {
        taskService.deleteTaskByTaskNo(task_no);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/task/{projId}")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable long projId) {
        List<Task> tasks = taskService.getTasksByProjectId(projId);
        return ResponseEntity.ok(tasks);
    }
//    @GetMapping("/{taskId}/{taskNo}")
//    public Optional<Task> getTask(@PathVariable long taskId, @PathVariable String taskNo) {
//        return taskService.getTaskByIdAndNo(taskId, taskNo);
//    }
    

    @PutMapping("/{taskId}/{taskNo}")
    public ResponseEntity<Task> updateTask(@PathVariable("taskId") long taskId, @PathVariable("taskNo") String taskNo,@RequestBody Task taskDetails) {
        Task updatedTask = taskService.updateTask(taskId, taskNo, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }
    
    
  

}
