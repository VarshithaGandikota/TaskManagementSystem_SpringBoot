package com.example.Task_Management1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.Task_Management1.service.ProjectService;
 
@RestController
@CrossOrigin
@RequestMapping("/api/projects")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	 @PostMapping("/add")
	    public Project createProject(@RequestBody Project project) {
	        return projectService.createProject(project);
	    }
	 


    @PostMapping("/user/{userId}")
    public ResponseEntity<Project> createProjectForUser(@PathVariable(value = "userId") Long userId,
                                                        @RequestBody Project project) {
        Project savedProject = projectService.saveProjectForUser(userId, project);
        return ResponseEntity.ok(savedProject);
    }
    
	  @PutMapping("/{id}")
	    public ResponseEntity<Project> updateProject(@PathVariable(value = "id") Long id,
	                                                 @RequestBody Project projectDetails) {
	        Project updatedProject = projectService.updateProject(id, projectDetails);
	        return ResponseEntity.ok(updatedProject);
	    }

	  
	  @GetMapping("/{id}")
	    public ResponseEntity<Project> getProjectById(@PathVariable(value = "id") Long id) {
	        Project project = projectService.getProjectById(id);
	        return ResponseEntity.ok().body(project);
	    }
	  

	    @GetMapping("/fetch")
	    public List<Project> getAllProjects() {
	        return projectService.getAllProjects();
	    }
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProject(@PathVariable(value = "id") Long id) {
	        projectService.deleteProject(id);
	        return ResponseEntity.noContent().build();
	    }
	    

	    @GetMapping("/user/{userId}")
	    public ResponseEntity<List<Project>> getProjectsByUserId(@PathVariable(value = "userId") Long userId) {
	        List<Project> projects = projectService.getProjectsByUserId(userId);
	        return ResponseEntity.ok().body(projects);
	    }
	    
	    @GetMapping("/{projectId}/userId")
	    public ResponseEntity<Long> getUserIdByProjectId(@PathVariable Long projectId) {
	        Long userId = projectService.getUserIdByProjectId(projectId);
	        if (userId != null) {
	            return ResponseEntity.ok(userId);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
}
