package com.kr.kopoctc.planningBridge.alarm.dto;

import com.kr.kopoctc.planningBridge.alarm.entity.Alarm;
import com.kr.kopoctc.planningBridge.project.entity.ProjectHistory;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmResult;
import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;
import com.kr.kopoctc.planningBridge.task.entity.TaskParticipant;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class AlarmDTO {
    private Long alarmPk;
    private ConfirmResult confirmResult;
    private ConfirmRequest confirmRequest;
    private TaskParticipant taskParticipant;
    private TaskHistory taskHistory;
    private ProjectHistory projectHistory;

    public Alarm toEntity() {
        return new Alarm(alarmPk, confirmResult, confirmRequest, taskParticipant, taskHistory, projectHistory);
    }
}
