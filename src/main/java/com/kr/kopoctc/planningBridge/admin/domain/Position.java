package com.kr.kopoctc.planningBridge.admin.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long positionPK;

    @Column
    private String name;
}
