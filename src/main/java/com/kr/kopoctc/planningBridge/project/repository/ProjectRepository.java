package com.kr.kopoctc.planningBridge.project.repository;

import com.kr.kopoctc.planningBridge.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {


    void deleteAllByProjectPKIn(List<Long> projectPKs);
}
