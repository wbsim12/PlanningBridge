package com.kr.kopoctc.planningBridge.alarm.entity;

import com.kr.kopoctc.planningBridge.project.entity.ProjectHistory;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmRequest;
import com.kr.kopoctc.planningBridge.task.entity.ConfirmResult;
import com.kr.kopoctc.planningBridge.task.entity.TaskHistory;
import com.kr.kopoctc.planningBridge.task.entity.TaskParticipant;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Setter
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long alarmPk;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConfirmResult confirmResult;

    @ManyToOne(fetch = FetchType.LAZY)
    private ConfirmRequest confirmRequest;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaskParticipant taskParticipant;

    @ManyToOne(fetch = FetchType.LAZY)
    private TaskHistory taskHistory;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProjectHistory projectHistory;

}
