package com.kr.kopoctc.planningBridge.schedule.entity;

import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String schedule_pk;

    @Column
    private LocalDateTime start_date;

    @Column
    private LocalDateTime end_date;

    @Column
    private String title;

    @Column
    private String detail;

    @Column
    private String priority;

//    @Column
//    enum repeat_status;

    @Column
    boolean type;

//    @Column
//    String user_pk;
}
