package com.kr.kopoctc.planningBridge.task.controller;


import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import com.kr.kopoctc.planningBridge.task.repository.TaskRepository;
import com.kr.kopoctc.planningBridge.task.service.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
@Slf4j
public class TaskController {

    private final TaskRepository taskRepository;
    private final TaskServiceImpl taskService;


    @GetMapping(value = {"", "/"})
    public String showTaskList(Model model) {
        // 로그인 확인
        Long EXISTING_USER_PK = 1L;

        // 로그인 유저의 프로젝트 번호 조회하기
        User user = taskService.getUserByUserPK(EXISTING_USER_PK);

        // 프로젝트 번호 별 Task 조회
        List<Long> projectPKList = taskService.getProjectListPKByUser(user);


        List<Task> taskList = taskService.getTaskByProject(projectPKList);

        model.addAttribute("tasks", taskList);
        return "task/taskList";
    }

    @GetMapping(value = {"/create"})
    public String getTaskCreateForm(Model model) {
        // 로그인 확인

        // 프로젝트 번호를 받아와 직책 확인 (PM이나 PL 인가)

        return "task/taskCreateForm";
    }

    @PostMapping(value = {"/create"})
    public String createTask(Model model) {
        // create
        return "task/taskList";
    }

    @GetMapping(value = {"/edit"})
    public String getTaskEditForm(Model model) {
        // 로그인 확인
        // 프로젝트 번호 확인
        // 해당 프로젝트 조회
        return "task/taskEditForm";
    }

    @PostMapping(value = {"/edit"})
    public String editTask(Model model) {
        // 로그인 확인
        // 프로젝트 번호 확인
        // 해당 프로젝트 조회
        return "task/taskEditForm";
    }


}
