package com.example.Task_Management1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Task_Management1.domain.Project;
import com.example.Task_Management1.domain.Task;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	@Query("select p from Project p where p.proj_name=?1")
	Project findByProj_name(String proj_name);
	
	@Query("select p from Project p where p.user.id=?1")
	List<Project> findByUserUserId(Long userId);

	  @Query("select p.user.user_id from Project p where p.proj_id =?1")
	    Long findUserIdByProjectId(@Param("projectId") Long proj_Id);

}
