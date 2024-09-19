package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;
import com.kr.kopoctc.planningBridge.task.entity.TaskParticipant;

public class TaskParticipantDTO {

    private boolean type;

    public TaskParticipant toEntity = TaskParticipant.builder()
            .type(this.type)
            .build();
}
