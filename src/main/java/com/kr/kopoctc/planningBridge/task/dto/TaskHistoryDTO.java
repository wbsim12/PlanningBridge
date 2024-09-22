package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;

import java.time.LocalDateTime;

public class TaskHistoryDTO {

    private LocalDateTime changedDate;
    private String changedDetail;

    public TaskHistory toEntity = TaskHistory.builder()
            .changedDate(this.changedDate)
            .changedDetail(this.changedDetail)
            .build();
}
