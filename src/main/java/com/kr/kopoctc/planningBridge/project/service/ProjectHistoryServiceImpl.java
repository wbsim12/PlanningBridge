package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.repository.ProjectHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectHistoryServiceImpl implements ProjectHistoryService{

    @Autowired
    private ProjectHistoryRepository projectHistoryRepository;
}
