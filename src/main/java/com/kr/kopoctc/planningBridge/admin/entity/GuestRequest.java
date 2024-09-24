package com.kr.kopoctc.planningBridge.admin.entity;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guest_request")
@NoArgsConstructor
@AllArgsConstructor
public class GuestRequest {
    @Id
    @Column(name = "guest_requestPk")
    private String guestRequestPk;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_pk", nullable = true)
    private Guest guest;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_pk", nullable = true)
    private Project project;

    @Column(name = "create_date")
    private LocalDateTime createdDate;
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "guestRequestEntity", cascade = CascadeType.ALL)
    private List<ProjectEntity> projectEntityList = new ArrayList<>();



}
