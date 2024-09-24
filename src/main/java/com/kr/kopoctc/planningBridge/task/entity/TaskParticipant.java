package com.kr.kopoctc.planningBridge.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class TaskParticipant {
    @Id
    private String taskParticipantPK;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_pk")
    @JsonBackReference
    private ProjectEntity project;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_pk")
    @JsonBackReference
    private Task task;

    private boolean type;

}
