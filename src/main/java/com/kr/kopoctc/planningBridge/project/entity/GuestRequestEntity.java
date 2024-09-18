package com.kr.kopoctc.planningBridge.project.entity;

import com.kr.kopoctc.planningBridge.project.dto.GuestRequestDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "guest_request")
public class GuestRequestEntity {
    @Id
    private String guestRequestPk;
    private String guestPK;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @OneToMany(mappedBy = "guestRequestEntity", cascade = CascadeType.ALL)
    private List<ProjectEntity> projectEntityList = new ArrayList<>();


}
