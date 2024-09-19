package com.kr.kopoctc.planningBridge.project.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectHistoryDTO {
    private String projectHistoryPK;
    private LocalDateTime changeDate;
    private String changeDetail;
    private String jobPK;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String projectPk;
    private String projectTeamPk;

}
