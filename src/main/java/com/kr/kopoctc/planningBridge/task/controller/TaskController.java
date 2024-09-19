package com.kr.kopoctc.planningBridge.task.controller;


import com.kr.kopoctc.planningBridge.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
@Slf4j
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = {"", "/"})
    public String showTaskList(Model model) {
        // 로그인 확인
        // 프로젝트 번호 확인
        // 해당 프로젝트 조회
        return "task/taskList";
    }

    @GetMapping(value = {"/create"})
    public String getTaskCreateForm(Model model) {
        // 로그인 확인
        // 프로젝트 번호 확인
        // 직책 확인
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
