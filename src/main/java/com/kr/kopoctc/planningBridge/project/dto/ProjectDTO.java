package com.kr.kopoctc.planningBridge.project.dto;
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
    private String desc;
    private String status;          // 상태 (PENDING, IN_PROGRESS, COMPLETED, HOLD)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String guestRequestPk;
    private List<String> projectHistoryEntityList;
    private List<String> ProjectTeamEntityList;
}
