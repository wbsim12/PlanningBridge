package com.kr.kopoctc.planningBridge.task.dto;

import com.kr.kopoctc.planningBridge.common.ConfirmStatus;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmResult;

public class ConfirmResultDTO {

    private ConfirmStatus status;
    private String date;


    public ConfirmResult toEntity = ConfirmResult.builder()
            .date(this.date)
            .status(this.status)
            .build();
}
