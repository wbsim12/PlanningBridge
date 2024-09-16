package com.kr.kopoctc.planningBridge.task.domain;

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
public class ConfirmRequest {
    @Id
    private String ConfirmRequestPK;

    private String date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "task_PK")
    @JsonBackReference
    private Task task;
}
