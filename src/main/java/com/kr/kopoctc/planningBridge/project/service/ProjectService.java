package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectEntity> findAllProjects(); // 자신의 프로젝트 전체 조회
    ProjectEntity findByProjectPK(String projectPK); // 선택 프로젝트 조회

}
