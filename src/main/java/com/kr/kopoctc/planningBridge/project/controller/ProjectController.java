package com.kr.kopoctc.planningBridge.project.controller;

import ch.qos.logback.core.model.Model;
import com.kr.kopoctc.planningBridge.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;


    // 프로젝트 전체 조회
    @GetMapping("/project")
    public String finadProjectList(Model model) {

        return "project/projectList";
    }
}
