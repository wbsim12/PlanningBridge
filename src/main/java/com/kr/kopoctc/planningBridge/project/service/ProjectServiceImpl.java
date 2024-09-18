package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import com.kr.kopoctc.planningBridge.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;

    // 모든 프로젝트 조회
    @Override
    public List<ProjectDTO> findAllProjects() {
        List<ProjectEntity> projectEntityList = projectRepository.findAll();
        return List.of();
    }




}
