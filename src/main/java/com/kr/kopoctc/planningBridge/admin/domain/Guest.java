package com.kr.kopoctc.planningBridge.admin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long guestPK;

    @Column
    private String company;

    @Column
    private String userPK;

    @Column
    private LocalDate createdDate;

    @Column
    private LocalDate updatedDate;

}
