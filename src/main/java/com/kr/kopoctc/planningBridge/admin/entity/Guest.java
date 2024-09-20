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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_item_id")
    private User user;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

}
