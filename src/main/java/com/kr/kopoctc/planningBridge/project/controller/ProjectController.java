package com.kr.kopoctc.planningBridge.project.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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

/*    // 프로젝트 생성 후 전체 조회 페이지로
    @PostMapping("/newProject")
    public String newProject(ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
        return "redirect:/project/projects";
    }*/
  // 프로젝트 생성 후 전체 조회 페이지로
    @PostMapping("/newProject")
    public String newProject(ProjectDTO projectDTO, @RequestParam("teamMembers") String teamMembersJson) {
        // 팀 멤버 JSON 데이터 로그 출력
        log.info("Received Project Name: {}", projectDTO.getName());
        log.info("Received Team Members: {}", teamMembersJson);

        // 서비스 계층에서 팀 멤버 정보를 저장
        projectService.saveProjectWithTeamMembers(projectDTO, teamMembersJson);
        return "redirect:/project/projects";
    }
    
    // 프로젝트 생성 페이지로 이동
    @GetMapping("/newProject")
    public String newProject(Model model) {
        model.addAttribute("priorities", Priority.values());
        model.addAttribute("responsibilities", ProjectTeamResponsibility.values());
        return "project/newProject";
    }

    // 선택 프로젝트 조회 -- > task랑 연결해야함 수정 필요
    @GetMapping("/findProject/{projectPK}")
    public String findProject(@PathVariable("projectPK") Long projectPK, Model model) {

        return "";
    }

    // 삭제 메서드
    @PostMapping("/deleteProjects")
    public String deleteProjects(@RequestParam(value = "selectedProjects", required = false) List<Long> selectedProjectIds) {
        if (selectedProjectIds != null && !selectedProjectIds.isEmpty()) {
            // 서비스에서 해당 프로젝트 삭제 처리
            projectService.deleteProjectsByIds(selectedProjectIds);
            log.info("Deleted project IDs: {}", selectedProjectIds);
        } else {
            log.warn("No projects selected for deletion.");
        }
        return "redirect:/project/projects";
    }

    // 수정 페이지로 이동
    @GetMapping("/editProject/{projectPK}")
    public String editProject(@PathVariable("projectPK") Long projectPK, Model model) {


        return "project/projectEdit";  // 템플릿 경로 반환
    }


    // 수정 후 프로젝트 보여주기
}
