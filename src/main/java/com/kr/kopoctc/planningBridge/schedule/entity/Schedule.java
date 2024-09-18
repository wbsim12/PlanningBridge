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
    LocalDateTime start_date;

    @Column
    LocalDateTime end_date;

    @Column
    String title;

    @Column
    Text detail;

    @Column
    String priority;

    @Column
    enum repeat_status;

    @Column
    boolean type;

    @Column
    @OneToMany
    String user_pk;
}
