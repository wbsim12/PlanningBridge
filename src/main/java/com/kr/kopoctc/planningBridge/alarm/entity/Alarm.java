package com.kr.kopoctc.planningBridge.alarm.entity;

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
    private String alarmPk;

    @Column
    private String division;
}
