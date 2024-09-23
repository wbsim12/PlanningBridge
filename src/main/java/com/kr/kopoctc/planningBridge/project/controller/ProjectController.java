package com.kr.kopoctc.planningBridge.project.controller;

import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.ProjectTeamResponsibility;
import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // 프로젝트 전체 조회
    @GetMapping("/projects")
    public String finadProjectList(Model model) {
        model.addAttribute("projects", projectService.findAllProjects());
        return "project/projectList";
    }

    // 프로젝트 생성 후 전체 조회 페이지로
    @PostMapping("/newProject")
    public String newProject(ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
        return "redirect:/project/projects";
    }
    
    // 프로젝트 생성 페이지로 이동
    @GetMapping("/newProject")
    public String newProject(Model model) {
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("responsibilities", ProjectTeamResponsibility.values());
        return "project/newProject";
    }

    // 선택 프로젝트 조회
    @GetMapping("/findProject/{projectPK}")
    public String findProject(Long projectPK) {
        return "project/projectFind";
    }
    
    // 삭제
    @PostMapping("/deleteProjects")
    public String deleteProjects(@RequestParam(value = "selectedProjects", required = false) List<Long> selectedProjectIds) {
        projectService.deleteProjectsByIds(selectedProjectIds);
        return "redirect:/project/projects";
    }

    // 수정 페이지로 이동
    @GetMapping("/editProject/{projectPK}")
    public String editProject(@PathVariable("projectPK") Long projectPK, Model model) {
        // 프로젝트 ID로 DTO를 가져옴
        ProjectDTO projectDTO = projectService.getProjectById(projectPK);

        // 모델에 프로젝트 데이터를 추가
        model.addAttribute("project", projectDTO);
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("responsibilities", ProjectTeamResponsibility.values());
        log.info("Project ID: " + projectPK);

        return "project/projectEdit";  // 템플릿 경로 반환
    }


    // 수정 후 프로젝트 보여주기
}
