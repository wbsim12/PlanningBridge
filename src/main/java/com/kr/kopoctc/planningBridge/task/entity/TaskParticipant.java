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
public class TaskParticipant {
    @Id
    private String taskParticipantPK;

     /*  @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "projectTeamPK")
    @JsonBackReference
    private ProjectTeamDTO projectTeam;*/

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "taskpk")
    @JsonBackReference
    private Task task;

    private boolean type;

}
