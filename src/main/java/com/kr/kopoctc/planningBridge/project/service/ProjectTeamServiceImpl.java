package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.repository.ProjectTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTeamServiceImpl implements ProjectTeamService{

    @Autowired
    private ProjectTeamRepository projectTeamRepository;

}
