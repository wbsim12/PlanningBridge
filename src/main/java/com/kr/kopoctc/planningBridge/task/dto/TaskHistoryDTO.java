package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;

public class TaskHistoryDTO {

    private String changedDate;
    private String changedDetail;

    public TaskHistory toEntity = TaskHistory.builder()
            .changedDate(this.changedDate)
            .changedDetail(this.changedDetail)
            .build();
}
