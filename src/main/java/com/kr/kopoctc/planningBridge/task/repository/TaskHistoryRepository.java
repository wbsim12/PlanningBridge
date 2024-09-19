package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, String> {
}
