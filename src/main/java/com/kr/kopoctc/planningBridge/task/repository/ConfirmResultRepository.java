package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmResultRepository extends JpaRepository<ConfirmRequest, String> {
}
