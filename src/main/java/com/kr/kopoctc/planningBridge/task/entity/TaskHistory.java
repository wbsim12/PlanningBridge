package com.kr.kopoctc.planningBridge.task.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class TaskHistory {
    @Id
    private String TaskHistoryPK;

    private String changedDate;
    private String changedDetail;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_pk")
    @JsonBackReference
    private Task task;
}
