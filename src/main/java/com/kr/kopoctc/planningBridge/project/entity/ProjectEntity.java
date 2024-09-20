package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.admin.entity.GuestRequest;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
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
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    @Id
    @Column(name = "project_pk")
    private String projectPK;
    private String name;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;
    private String priority;
    @Column(name = "project_desc")
    private String projectDesc;
    private ProjectStatus status;
    @Column(name = "create_date")
    private LocalDateTime createdDate;
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "guest_request_pk")
    private GuestRequest guestRequestEntity;

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectHistoryEntity> projectHistoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectTeamEntity> ProjectTeamEntityList = new ArrayList<>();




}
