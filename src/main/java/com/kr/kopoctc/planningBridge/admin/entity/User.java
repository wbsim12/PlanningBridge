package com.kr.kopoctc.planningBridge.admin.entity;

import com.kr.kopoctc.planningBridge.project.entity.ProjectTeam;
import lombok.*;

import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
@Entity
@Builder
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "users_id_seq", allocationSize = 1)
    private Long userPK;

    @Column(unique = true, nullable = false)
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
    private LocalDateTime lastChangedPassword;

    @Column
    private boolean passwordExpired = false;

    @Column
    private boolean checkAdmin = false;

    @Column
    private boolean checkGuest = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_pk", nullable = true)
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_pk", nullable = true)
    private Position position;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Column
    private boolean isDeleted;

    @Column
    private String role;
}



