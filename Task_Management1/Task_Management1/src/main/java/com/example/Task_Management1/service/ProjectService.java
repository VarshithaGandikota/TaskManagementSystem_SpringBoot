package com.example.Task_Management1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.Task_Management1.domain.Project;
import com.example.Task_Management1.domain.User;
import com.example.Task_Management1.exception.NameAlreadyExistsException;
import com.example.Task_Management1.exception.ResourceNotFoundException;
import com.example.Task_Management1.repository.ProjectRepository;
import com.example.Task_Management1.repository.UserRepository;

@Service
@Component
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project createProject(Project project) {
        if (projectRepository.findByProj_name(project.getProj_name()) != null) {
            throw new NameAlreadyExistsException("Project name already exists: " + project.getProj_name());
        }
        return projectRepository.save(project);
    }

	

    @Autowired
    private UserRepository userRepository;

    public Project saveProjectForUser(Long userId, Project project) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));

        project.setUser(user);  // Set the user in the project
        return projectRepository.save(project);
    }
    
	 public Project updateProject(long id, Project projectDetails) {
	        Project project = getProjectById(id);

	        if (!project.getProj_name().equals(projectDetails.getProj_name()) &&
	            projectRepository.findByProj_name(projectDetails.getProj_name()) != null) {
	            throw new NameAlreadyExistsException("Project name already exists: " + projectDetails.getProj_name());
	        }

	        project.setProj_name(projectDetails.getProj_name());
	        project.setProj_owner(projectDetails.getProj_owner());
	        project.setProj_created_date(projectDetails.getProj_created_date());
	        project.setProj_description(projectDetails.getProj_description());

	        return projectRepository.save(project);
	    }
	 
	    public Project getProjectById(long id) {
	        return projectRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
	    }
	    
	    public List<Project> getAllProjects() {
	        return projectRepository.findAll();
	    }

	    public void deleteProject(long id) {
	        Project project = getProjectById(id);
	        projectRepository.delete(project);
	    }
	    
	    public List<Project> getProjectsByUserId(Long userId) {
	        return projectRepository.findByUserUserId(userId);
	    }
	    

	    public Long getUserIdByProjectId(Long projectId) {
	        return projectRepository.findUserIdByProjectId(projectId);
	    }
}
