package com.kr.kopoctc.planningBridge.admin.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long guestPK;


    @Column
    private String company;

    @Column
    private String userPK;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

}
