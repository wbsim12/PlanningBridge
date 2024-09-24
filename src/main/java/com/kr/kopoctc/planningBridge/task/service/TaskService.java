package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.task.dto.TaskDTO;
import com.kr.kopoctc.planningBridge.task.entity.Task;

import java.util.List;

public interface TaskService {
    // 로그인 유저의 프로젝트 번호 리스트 조회하기
    public List<String> getProjectListPKByUser();

    // 프로젝트 번호 별 Task 조회
    public List<Task> getTaskByProject(String projectPK);

    // 내게 할당된 Task 만 조회하기
    public List<Task> getTaskOnlyMine(String projectPK);

    // 프로젝트 번호를 받아와 직책 확인 (PM이나 PL 인가)
    public boolean isProjectAdmin(String projectPK);

    // 프로젝트 생성
    public void addTask(TaskDTO taskDTO, String projectTeamPK);

    // 프로젝트 수정
    public void updateTask(TaskDTO taskDTO, String projectTeamPK);

    //프로젝트 삭제
    public void deleteTask(String taskPK);
}
