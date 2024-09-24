package com.kr.kopoctc.planningBridge.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long departmentPK;

    @Column
    private String name;

    @Column
    private boolean IsDeleted;
}
