package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.common.ProjectTeamResponsibility;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project_team")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectTeam {
    @Id
    @Column(name = "project_team_pk")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectTeamPK;

/*    @Column(name = "user_pk")
    private String userPK;*/

    private ProjectTeamResponsibility responsibility;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedDate = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "project_pk")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_pk")
    private User userPK;

    @OneToMany(mappedBy = "projectTeam", cascade = CascadeType.ALL)
    private List<ProjectHistory> projectHistoryList = new ArrayList<>();



}
