package com.kr.kopoctc.planningBridge.task.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kr.kopoctc.planningBridge.common.ConfirmStatus;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class ConfirmResult {
    @Id
    private String ConfirmResultPK;

    private ConfirmStatus status;
    private String date;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "confirm_requestpk")
    @JsonBackReference
    private ConfirmRequest confirmRequest;

  /*  @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "projectTeamPK")
    @JsonBackReference
    private ProjectTeam projectTeam;*/


}
