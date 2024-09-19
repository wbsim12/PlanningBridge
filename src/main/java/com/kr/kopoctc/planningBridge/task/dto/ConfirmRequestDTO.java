package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.Task;

public class ConfirmRequestDTO {

    private String date;

    public ConfirmRequest toEntity = ConfirmRequest.builder()
            .date(this.date)
            .build();
}
