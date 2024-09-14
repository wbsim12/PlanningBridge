package com.kr.kopoctc.planningBridge.admin.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
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
    private String contactInfo;

    @Column
    private LocalDate joinDate;

    @Column
    private String name;

    @Column
    private boolean status;

    @Column
    private LocalDate lastChanagedPassword;

    @Column
    private boolean passwordExpired;

    @Column
    private boolean checkAdmin;

    @Column
    private boolean checkGuest;

    @Column
    private String departmentPK;

    @Column
    private String positionPK;

    @Column
    private LocalDate createdDate;

    @Column
    private LocalDate updatedDate;

}
