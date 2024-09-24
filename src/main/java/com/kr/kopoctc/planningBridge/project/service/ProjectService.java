package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.entity.Project;

import java.util.List;

public interface ProjectService {
    List<Project> findAllProjects();
   // ProjectEntity saveProject(ProjectDTO projectDTO, String teamMembersJson);
    Project saveProject(ProjectDTO projectDTO);
    void deleteProjectsByIds(List<Long> selectedProjectIds);
}
