package com.kr.kopoctc.planningBridge.schedule.dto;

import com.kr.kopoctc.planningBridge.admin.domain.User;
import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.RepeatStatus;
import com.kr.kopoctc.planningBridge.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ScheduleDTO {

    private String schedule_pk;
    private LocalDateTime start_date;
    private LocalDateTime end_date;
    private String title;
    private String detail;
    private Priority priority;
    private RepeatStatus repeatStatus;
    private boolean type;
    private User user;

    public Schedule toEntity() {
        return new Schedule(schedule_pk, start_date, end_date, title, detail, priority, repeatStatus, type, user);
    }
}
