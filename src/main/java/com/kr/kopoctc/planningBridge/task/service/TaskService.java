package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.task.dto.TaskDTO;
import com.kr.kopoctc.planningBridge.task.entity.Task;

import java.util.List;

public interface TaskService {
    // 로그인 유저 account에서 User 객체 불러오기
    public User getUserByUserPK(Long userPK);

    // 로그인 유저의 프로젝트 번호 리스트 조회하기
    public List<Long> getProjectListPKByUser(User user);

    // 프로젝트 번호 별 Task 조회
    public List<Task> getTaskByProject(List<Long> projectPK);

    // 내게 할당된 Task 만 조회하기
    public List<Task> getTaskOnlyMine(Long projectPK);

    // 프로젝트 번호를 받아와 직책 확인 (PM이나 PL 인가)
    public boolean isProjectAdmin(Long projectPK);

    // 프로젝트 생성
    public void addTask(TaskDTO taskDTO, Long projectTeamPK);

    // 프로젝트 수정
    public void updateTask(TaskDTO taskDTO, Long projectTeamPK);

    //프로젝트 삭제
    public void deleteTask(Long taskPK);
}
