package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectEntity> findAllProjects();
    ProjectEntity saveProject(ProjectDTO projectDTO);
    void deleteProjectsByIds(List<Long> selectedProjectIds);

    ProjectDTO getProjectById(Long projectID);
}
