package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {

    List<ProjectDTO> findAllProjects();
}
