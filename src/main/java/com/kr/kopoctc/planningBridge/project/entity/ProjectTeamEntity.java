package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.ProjectTeamDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project_team")
public class ProjectTeamEntity {
    @Id
    private String projectTeamPK;
    private String userPK;
    private enum Responsibility {
        PM,
        PL,
        PA
    }
    private Responsibility responsibility;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "project_pk")
    private ProjectEntity projectEntity;

    @OneToMany(mappedBy = "projectTeamEntity", cascade = CascadeType.ALL)
    private List<ProjectHistoryEntity> projectHistoryEntityList = new ArrayList<>();

/*    public ProjectTeamDTO toProjectTeamDTO() {
        ProjectTeamDTO projectTeamDTO = new ProjectTeamDTO();
        projectTeamDTO.setProjectTeamPK(this.projectTeamPK);
        projectTeamDTO.setResponsibility(this.responsibility.name());
        projectTeamDTO.setCreatedDate(this.createdDate);
        projectTeamDTO.setUpdatedDate(this.updatedDate);
        return projectTeamDTO;
    }*/
}
