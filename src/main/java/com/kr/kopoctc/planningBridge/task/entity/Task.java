package com.kr.kopoctc.planningBridge.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.TaskStatus;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter @Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "task_pk")
    private Long taskPK;

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String description;
    private Priority priority;
    private TaskStatus status;
    private LocalDateTime createdDate;
    private boolean is_deleted;

    // 프로젝트 객체 생성시 주석풀기
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_pk")
    @JsonBackReference
    private ProjectEntity project;

    // 셀프조인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task_pk")
    private Task parentTask;

    @OneToMany (mappedBy = "parentTask", cascade = CascadeType.ALL)
    private List<Task> subTaskList = new ArrayList<>();

/*    public Task(String taskPK, String name, String startDate, String endDate, String desc, Priority priority, TaskStatus status, String createdDate, String updatedDate) {
        this.taskPK = taskPK;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.desc = desc;
        this.priority = priority;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }*/

}
