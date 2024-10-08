package com.kr.kopoctc.planningBridge.admin.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userPK;

    @Column // 계정명
    private String account;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private String name;

    @Column
    private boolean isActive = false;

    @Column
    private LocalDateTime lastChanagedPassword;

    @Column
    private boolean passwordExpired = false;

    @Column
    private boolean checkAdmin = false;

    @Column
    private boolean checkGuest = false;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="department_pk")
    private Department department;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="position_pk")
    private Position position;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

}
