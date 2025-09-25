package com.example.Task_Management1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Task_Management1.domain.Task;
import com.example.Task_Management1.domain.TaskId;


@Repository
public interface TaskRepository extends JpaRepository<Task, TaskId> {
	
	@Query("select t from Task t where t.task_no=?1")
	 Optional<Task> findByTask_no(String task_no);
	
	@Query("select t from Task t where t.task_no=?1")
	 Task findByTask(String task_no);
	
	@Query("select t from Task t where t.project.proj_id=?1")
	 List<Task> findByProject_ProjId(long proj_id);
	
	@Query("select t from Task t where t.task_id=?1 and t.task_no=?2")
	Optional<Task> findByTaskIdAndTaskNo(long task_id, String task_no);
}
