package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.admin.entity.GuestRequest;
import com.kr.kopoctc.planningBridge.common.ProjectStatus;
import com.kr.kopoctc.planningBridge.task.entity.Task;
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
public class Project {
    @Id
    @Column(name = "project_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private GuestRequest guestRequest;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectHistory> projectHistoryList = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectTeam> ProjectTeamList = new ArrayList<>();

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();


}
