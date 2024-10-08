package com.kr.kopoctc.planningBridge.schedule.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.RepeatStatus;
import jakarta.persistence.*;
import lombok.*;



import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Getter
@Setter
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String schedulePk;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column
    private String title;

    @Column
    private String detail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RepeatStatus repeatStatus;

    @Column
    private boolean type;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn
    @JsonBackReference
    private User user;
}
