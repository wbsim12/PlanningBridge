package com.kr.kopoctc.planningBridge.admin.repository;

import com.kr.kopoctc.planningBridge.admin.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
