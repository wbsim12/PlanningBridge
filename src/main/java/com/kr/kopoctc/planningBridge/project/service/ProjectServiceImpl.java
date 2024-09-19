package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import com.kr.kopoctc.planningBridge.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    private static ProjectRepository projectRepository;

    // 자신의 프로젝트 전체 조회
    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }
    // 선택 프로젝트 조회
    @Override
    public ProjectEntity findByProjectPK(String projectPK){
        return projectRepository.findById(projectPK).get();
    }
}
