package com.kr.kopoctc.planningBridge.admin.service;

import com.kr.kopoctc.planningBridge.admin.entity.Department;
import com.kr.kopoctc.planningBridge.admin.entity.Position;
import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.entity.Guest;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import com.kr.kopoctc.planningBridge.admin.repository.DepartmentRepository;
import com.kr.kopoctc.planningBridge.admin.repository.GuestRepository;
import com.kr.kopoctc.planningBridge.admin.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final GuestRepository guestRepository;
    private final PositionRepository positionRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public void createUser(UserDTO userDTO) {

        User user = userDTO.toEntity();

        if (userDTO.getDepartmentPK() != null && userDTO.getPositionPK() != null) {
            user.setDepartment(departmentRepository.findById(userDTO.getDepartmentPK()).orElse(null));

            user.setPosition(positionRepository.findById(userDTO.getPositionPK()).orElse(null));
        }

        log.info("null이 말이야");

        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 인코딩

        userRepository.save(user);

        // Guest 정보 생성 및 저장
        if (user.isCheckGuest()) {
            Guest guest = new Guest();
            guest.setUser(user);
            guest.setCompany(userDTO.getCompany());
            guest.setCreatedDate(LocalDateTime.now());
            guest.setUpdatedDate(LocalDateTime.now());

            guestRepository.save(guest);
        }
    }

    // Guest도 User이다
    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account).orElse(null);
    }
}
