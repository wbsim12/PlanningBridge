package com.kr.kopoctc.planningBridge.admin.dto;

import com.kr.kopoctc.planningBridge.admin.entity.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "아이디를 입력해주세요")
    private String account;

    @NotBlank(message = "패스워드를 입력해주세요")
    @Size(min = 8, message = "패스워드는 적어도 8자리 이상이어야 합니다")
    private String password;

    @Email(message = "유효한 이메일 형식으로 작성해 주세요")
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;

    @NotBlank(message = "연락처를 입력해주세요")
    private String phoneNumber;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    private boolean isActive = false;

    private LocalDateTime lastChanagedPassword;

    private boolean passwordExpired = false;

    private boolean checkAdmin = false;

    private boolean checkGuest = false;

    private String company;

    private Integer departmentPK;

    private Integer positionPK;

    private boolean isDeleted = false;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    public User toEntity() {
        return User.builder()
                .account(this.account)
                .password(this.password)
                .email(this.email)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .name(this.name)
                .passwordExpired(this.passwordExpired)
                .checkGuest(this.checkGuest)
                .checkAdmin(this.checkAdmin)
                .isActive(this.isActive)
                .phoneNumber(this.phoneNumber)
                .lastChangedPassword(LocalDateTime.now())
                .build();

        // account, email, checkAdmin, name, checkGuest, phoneNumber, departmentPK, positionPK
        // 뷰 페이지 노출 값
    }
}
