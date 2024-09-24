package com.kr.kopoctc.planningBridge.project.dto;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
import com.kr.kopoctc.planningBridge.admin.entity.GuestRequest;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectDTO {
    private Long projectPK;
    private String name;
    private LocalDate startDate;
    private LocalDate  endDate;
    private String priority;
    private String description;
    private String status = "PENDING";          // 상태 (PENDING, IN_PROGRESS, COMPLETED, HOLD)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private boolean isDeleted;
    private String guestRequestPk;
    private List<String> projectHistoryEntityList;
    private List<String> ProjectTeamEntityList;

   // DTO -> Entity
    public ProjectEntity toEntity(GuestRequest guestRequestEntity) {
        ProjectEntity projectEntity = new ProjectEntity();
        projectEntity.setProjectPK(this.projectPK);
        projectEntity.setName(this.name);
        projectEntity.setStartDate(this.startDate);
        projectEntity.setEndDate(this.endDate);
        projectEntity.setPriority(this.priority);
        projectEntity.setDescription(this.description);
        projectEntity.setStatus(ProjectStatus.valueOf(this.status));
        projectEntity.setCreatedDate(this.createdDate);
        projectEntity.setUpdatedDate(this.updatedDate);
        projectEntity.setDeleted(this.isDeleted);
       // projectEntity.setGuestRequestEntity(guestRequestEntity);
        return projectEntity;
    }

    //


}
