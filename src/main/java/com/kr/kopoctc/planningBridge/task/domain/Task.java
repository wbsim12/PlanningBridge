package com.kr.kopoctc.planningBridge.task.domain;

import com.kr.kopoctc.planningBridge.common.Priority;
import com.kr.kopoctc.planningBridge.common.TaskStatus;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
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
    @Column(name = task_PK)
    private String taskPK;

    private String name;
    private String startDate;
    private String endDate;
    private String desc;
    private Priority priority;
    private TaskStatus status;
    private String createdDate;
    private String updatedDate;

    // 프로젝트 객체 생성시 주석풀기
    /*@ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "projectPK")
    @JsonBackReference
    private Project project;*/

    // 셀프조인
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_PK")
    private Task parentTask;

    @OneToMany (mappedBy = "parentTask", cascade = CascadeType.ALL)
    private List<Task> subTaskList = new ArrayList<>();
}
