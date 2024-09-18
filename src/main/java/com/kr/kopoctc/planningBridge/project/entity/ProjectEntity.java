package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    private String projectPK;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priority;
    private String desc;
    private enum Status{
        PENDING, // 대기
        IN_PROGRESS, // 진행
        COMPLETED, // 완료
        HOLD          // 홀드
        // CANCELLED // 취소도 넣어야하나 ?
    }
    private Status status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToOne
    @JoinColumn(name = "guest_request_pk")
    private GuestRequestEntity guestRequestEntity;

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectHistoryEntity> projectHistoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectTeamEntity> ProjectTeamEntityList = new ArrayList<>();

   /* public ProjectDTO toProjectDTO() {
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjectPK(this.projectPK);
        projectDTO.setName(this.name);
        projectDTO.setStartDate(this.startDate);
        projectDTO.setEndDate(this.endDate);
        projectDTO.setPriority(this.priority);
        projectDTO.setDesc(this.desc);
        projectDTO.setStatus(this.status.name()); // enum 값을 그대로 문자열로 반환
        projectDTO.setCreatedDate(this.createdDate);
        projectDTO.setUpdatedDate(this.updatedDate);
        return projectDTO;
    }*/

}
