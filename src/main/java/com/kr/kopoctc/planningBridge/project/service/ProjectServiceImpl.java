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

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity saveProject(ProjectDTO projectDTO){
        ProjectEntity projectEntity = projectDTO.toEntity(null);
        return projectRepository.save(projectEntity);
    }

    // 수정진행중 ..
    @Override
    public void deleteProjectsByIds(List<Long> selectedProjectIds) {
        projectRepository.deleteAllById(selectedProjectIds);
    }

    @Override
    public ProjectDTO getProjectById(Long projectID) {
        projectRepository.findById(projectID);
        return null;
    }

}