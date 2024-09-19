package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.GuestRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guest_request")
@NoArgsConstructor
@AllArgsConstructor
public class GuestRequestEntity {
    @Id
    @Column(name = "guest_requestPk")
    private String guestRequestPk;
    @Column(name = "guest_pk")
    private String guestPK;
    @Column(name = "create_date")
    private LocalDateTime createdDate;
    @Column(name = "update_date")
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "guestRequestEntity", cascade = CascadeType.ALL)
    private List<ProjectEntity> projectEntityList = new ArrayList<>();


}
