package com.kr.kopoctc.planningBridge.project.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProjectTeamDTO {
    private String projectTeamPK;
    private String userPK;
    private String responsibility;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private String projectPk;
    private List<String> projectHistoryEntityList;

}
