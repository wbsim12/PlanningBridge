package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.admin.entity.GuestRequest;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectEntity {
    @Id
    @Column(name = "project_pk")
    @SequenceGenerator(
            name = "project_seq_gen", // 시퀀스 제너레이터 이름
            sequenceName = "project_seq", // 실제 DB에 생성될 시퀀스 이름
            allocationSize = 1 // 기본값은 50인데, 1로 설정하면 1씩 증가
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq_gen")
    private Long projectPK;

    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate  endDate;

    private String priority;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private ProjectStatus status;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "guest_request_pk")
    private GuestRequest guestRequestEntity;

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectHistoryEntity> projectHistoryEntityList = new ArrayList<>();

    @OneToMany(mappedBy = "projectEntity", cascade = CascadeType.ALL)
    private List<ProjectTeamEntity> ProjectTeamEntityList = new ArrayList<>();


}
