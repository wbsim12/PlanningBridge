package com.kr.kopoctc.planningBridge.alarm.dto;

import com.kr.kopoctc.planningBridge.alarm.entity.Alarm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class AlarmDTO {
    private String alarmPk;
    private String division;

    public Alarm toEntity() {
        return new Alarm(alarmPk, division);
    }
}
