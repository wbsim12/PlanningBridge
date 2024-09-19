package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.TaskStatus;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDTO {

    private String name;
    private String startDate;
    private String endDate;
    private String desc;
    private Priority priority;
    private TaskStatus status;
    private String createdDate;
    private String updatedDate;

    public Task toEntity = Task.builder()
            .name(this.name)
            .startDate(this.startDate)
            .endDate(this.endDate)
            .description(this.desc)
            .priority(this.priority)
            .status(this.status)
            .createdDate(this.createdDate)
            .updatedDate(this.updatedDate)
            .build();
}
