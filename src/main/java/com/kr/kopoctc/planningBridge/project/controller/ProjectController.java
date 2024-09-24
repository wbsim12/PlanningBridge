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
import java.util.Map;

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
   /* // 프로젝트 생성 후 전체 조회 페이지로
    @PostMapping("/newProject")
    public String newProject(ProjectDTO projectDTO, @RequestParam("teamMember") String teamMembersJson) {
        // 팀 멤버 JSON 데이터 로그 출력
        log.info("Received Project Name: {}", projectDTO.getName());
        log.info("Received Team Members: {}", teamMembersJson);

        // teamMembersJson을 파싱하여 처리하는 로직 추가 필요
        projectService.saveProject(projectDTO, teamMembersJson);
        return "redirect:/project/projects";
    }*/
    
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

    // 삭제
    @PostMapping("/deleteProjects")
    public String deleteProjects(@RequestParam(value = "selectedProjects", required = false) List<Long> selectedProjectIds) {
        projectService.deleteProjectsByIds(selectedProjectIds);
        return "redirect:/project/projects";
    }

    // 수정 페이지로 이동
    @GetMapping("/editProject/{projectPK}")
    public String editProject(@PathVariable("projectPK") Long projectPK, Model model) {


        return "project/projectEdit";  // 템플릿 경로 반환
    }


    // 수정 후 프로젝트 보여주기
}
