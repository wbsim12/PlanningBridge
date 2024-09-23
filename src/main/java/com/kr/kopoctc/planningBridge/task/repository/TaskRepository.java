package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, String> {
    //List<Task> findByProject_ProjectPK(String projectPK);
    List<Task> findByProjectPK(String projectPK);
}
