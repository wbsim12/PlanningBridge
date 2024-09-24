package com.kr.kopoctc.planningBridge.project.dto;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
import com.kr.kopoctc.planningBridge.admin.entity.GuestRequest;
import com.kr.kopoctc.planningBridge.project.entity.Project;
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
    private List<String> projectHistoryList;
    private List<String> ProjectTeamList;

   // DTO -> Entity
    public Project toEntity(GuestRequest guestRequest) {
        Project project = new Project();
        project.setProjectPK(this.projectPK);
        project.setName(this.name);
        project.setStartDate(this.startDate);
        project.setEndDate(this.endDate);
        project.setPriority(this.priority);
        project.setDescription(this.description);
        project.setStatus(ProjectStatus.valueOf(this.status));
        project.setCreatedDate(this.createdDate);
        project.setUpdatedDate(this.updatedDate);
        project.setDeleted(this.isDeleted);
       // project.setGuestRequestEntity(guestRequestEntity);
        return project;
    }

    //


}
