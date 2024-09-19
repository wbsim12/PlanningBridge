package com.kr.kopoctc.planningBridge.project.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GuestRequestDTO {
    private String guestRequestPk;
    private String guestPK;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private List<String> projectEntityList;

}
