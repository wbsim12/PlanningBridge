package com.kr.kopoctc.planningBridge.project.dto;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
import com.kr.kopoctc.planningBridge.project.entity.GuestRequestEntity;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {
    private String projectPK;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priority;
    private String description;
    private String status;          // 상태 (PENDING, IN_PROGRESS, COMPLETED, HOLD)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isDeleted;
    private String guestRequestPk;
    private List<String> projectHistoryEntityList;
    private List<String> ProjectTeamEntityList;

   // DTO -> Entity
    public ProjectEntity toEntity(GuestRequestEntity guestRequestEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectPK(this.projectPK);
        projectEntity.setName(this.name);
        projectEntity.setStartDate(this.startDate);
        projectEntity.setEndDate(this.endDate);
        projectEntity.setPriority(this.priority);
        projectEntity.setDescription(this.description);
        projectEntity.setStatus(ProjectStatus.valueOf(this.status.toUpperCase()));
        projectEntity.setCreatedDate(this.createdDate);
        projectEntity.setUpdatedDate(this.updatedDate);
        projectEntity.setGuestRequestEntity(guestRequestEntity);
        return projectEntity;
    }
}
