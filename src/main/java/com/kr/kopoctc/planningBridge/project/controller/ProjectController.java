package com.kr.kopoctc.planningBridge.project.controller;

import com.kr.kopoctc.planningBridge.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 프로젝트 전체 조회
    @GetMapping("/")
    public String finadProjectList(Model model) {
      //  model.addAttribute("projects", projectService.findAllProjects());
        return "project/projectList";
    }

    // 선택 프로젝트 조회
    @GetMapping("/findProject")
    public String findProject(Model model) {
        return "project/projectFind";
    }

}
