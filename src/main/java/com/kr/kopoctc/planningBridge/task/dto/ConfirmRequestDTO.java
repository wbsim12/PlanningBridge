package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.Task;

import java.time.LocalDateTime;

public class ConfirmRequestDTO {

    private LocalDateTime date;

    public ConfirmRequest toEntity = ConfirmRequest.builder()
            .date(this.date)
            .build();
}
