package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.common.ConfirmStatus;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmResult;

import java.time.LocalDateTime;

public class ConfirmResultDTO {

    private ConfirmStatus status;
    private LocalDateTime date;


    public ConfirmResult toEntity = ConfirmResult.builder()
            .date(this.date)
            .status(this.status)
            .build();
}
