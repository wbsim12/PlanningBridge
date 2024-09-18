package com.kr.kopoctc.planningBridge.schedule.dto;

import com.kr.kopoctc.planningBridge.schedule.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@AllArgsConstructor
@ToString
@Getter
@Setter
public class ScheduleForm {

    String schedule_pk;
    LocalDateTime start_date;
    LocalDateTime end_date;
    String title;
    Text detail;
    String priority;
//    enum repeat_status;
    boolean type;
    String user_pk;

//    public void toEntity(){
//        return new Schedule(schedule_pk, start_date, end_date, title, detail, priority, repeat_status, type, user_pk);
//    }
}
