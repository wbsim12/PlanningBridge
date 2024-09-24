package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.TaskStatus;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TaskDTO {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private Priority priority;
    private TaskStatus status;

    public Task toEntity(LocalDateTime currDate) {
        return Task.builder()
                .name(this.name)
                .startDate(this.startDate)
                .endDate(this.endDate)
                .description(this.description)
                .priority(this.priority)
                .status(this.status)
                .createdDate(currDate)
                .build();
    }
}
