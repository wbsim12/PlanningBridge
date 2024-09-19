package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.task.entity.TaskParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskParticipantRepository extends JpaRepository<TaskParticipant, String> {
}
