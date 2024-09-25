package com.kr.kopoctc.planningBridge.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.TaskStatus;
import com.kr.kopoctc.planningBridge.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne(optional = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_pk")
    private Project project;

    // 셀프조인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_task_pk")
    @JsonBackReference
    private Task parentTask;

    @Builder.Default
    @OneToMany (mappedBy = "parentTask", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Task> subTaskList = new ArrayList<>();

    @Override
    public String toString() {
        return "Task{" +
                "taskPK=" + taskPK +
                ", name='" + name + '\'' +
                '}';
    }
}
