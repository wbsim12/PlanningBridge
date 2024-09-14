package com.kr.kopoctc.planningBridge.admin.entity;

import com.kr.kopoctc.planningBridge.admin.enums.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "user_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userHistoryPK;

    @Column
    private UserType changeType;

    @Column
    private LocalDate changeDate;

    @Column
    private String changeDetail;

    @Column
    private String userPK;

}
