package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.task.dto.TaskDTO;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import com.kr.kopoctc.planningBridge.task.repository.TaskRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

 /*   @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }*/

    //세션에서부터 얻은 값이라 가정한다.
    int userPK = 1;

    // 로그인 유저의 프로젝트 번호 조회하기
    @Override
    public List<String> getProjectListPKByUser() {



        return List.of("account");
    }

    // 프로젝트 번호 별 Task 조회
    @Override
    public List<Task> getTaskByProject(String projectPK) {
        //List<Task> taskList = taskRepository.findByProjectPK(projectPK);
        //return taskList;
        return List.of();
    }

    @Override
    public List<Task> getTaskOnlyMine(String projectPK) {
        return List.of();
    }

    // 프로젝트 번호를 받아와 직책 확인 (PM이나 PL 인가)
    @Override
    public boolean isProjectAdmin(String projectPK) {
        return false;
    }

    // 프로젝트 생성
    @Override
    public void addTask(TaskDTO taskDTO, String projectTeamPK) {
    // task 객체 생성 부분
        LocalDateTime now = LocalDateTime.now();
        Task newTask = taskDTO.toEntity(now);
        // 프로젝트 번호에서 프로젝트 객체 가져오기

        // 프로젝트 팀 객체를 Task에 넣기


    // task_participant 객체 생성 부분
        // 로그인 정보에서 -> project Team 엔티티 가져오기
            // type 0으로 저장
        // form 에서 -> project Team 엔티티 가져오기
            // type 1으로 저장

    }

    @Override
    public void updateTask(TaskDTO taskDTO, String projectTeamPK) {

    }

    @Override
    public void deleteTask(String taskPK) {

    }
}
