package com.kr.kopoctc.planningBridge.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kr.kopoctc.planningBridge.common.ConfirmStatus;
import com.kr.kopoctc.planningBridge.project.entity.Project;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class ConfirmResult {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long ConfirmResultPK;

    private ConfirmStatus status;
    private LocalDateTime date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "confirm_requestpk")
    @JsonBackReference
    private ConfirmRequest confirmRequest;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "project_pk")
    @JsonBackReference
    private Project project;


}
