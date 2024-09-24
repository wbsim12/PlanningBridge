package com.kr.kopoctc.planningBridge.project.repository;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {


    void deleteAllByProjectPKIn(List<Long> projectPKs);
}
