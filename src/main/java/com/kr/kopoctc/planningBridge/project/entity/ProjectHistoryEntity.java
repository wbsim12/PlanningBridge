package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.ProjectHistoryDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "project_history")
public class ProjectHistoryEntity {
    @Id
    private String projectHistoryPK;
    private LocalDateTime changeDate;
    private String changeDetail;
    private String jobPK;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "project_pk")
    private ProjectEntity projectEntity;

    @ManyToOne
    @JoinColumn(name = "project_team_pk")
    private ProjectTeamEntity projectTeamEntity;

    /*public ProjectHistoryDTO toProjectHistoryDIO() {
        ProjectHistoryDTO projectHistoryDTO = new ProjectHistoryDTO();
        projectHistoryDTO.setProjectHistoryPK(this.projectHistoryPK);
        projectHistoryDTO.setChangeDate(this.changeDate);
        projectHistoryDTO.setChangeDetail(this.changeDetail);
        projectHistoryDTO.setJobPK(this.jobPK);
        projectHistoryDTO.setCreatedDate(this.createdDate);
        projectHistoryDTO.setUpdatedDate(this.updatedDate);
        return projectHistoryDTO;
    }*/
}
