package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.task.entity.Task;

public interface TaskService {
    // 유저 별 프로젝트 번호 조회하기
    public String getProjectPKByUser();

    // 프로젝트 번호 별 Task 조회
    public Task getTaskByProject();

    //
}
