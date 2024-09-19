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
public class ConfirmRequest {
    @Id
    private String ConfirmRequestPK;

    private String date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "taskpk")
    @JsonBackReference
    private Task task;


}
