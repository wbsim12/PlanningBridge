package com.kr.kopoctc.planningBridge.project.repository;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<ProjectEntity, String> {


}
