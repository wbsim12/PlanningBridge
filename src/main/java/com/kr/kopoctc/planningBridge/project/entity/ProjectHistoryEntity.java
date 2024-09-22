package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.ProjectHistoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "project_history")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectHistoryEntity {
    @Id
    @Column(name = "project_history_pk")
    private String projectHistoryPK;

    @Column(name = "change_date")
    private LocalDateTime changeDate;

    @Column(name = "change_detail")
    private String changeDetail;

    @Column(name = "job_pk")
    private String jobPK;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "project_pk")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name = "project_team_pk")
    private ProjectTeamEntity projectTeamEntity;



}
