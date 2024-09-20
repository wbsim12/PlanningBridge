package com.kr.kopoctc.planningBridge.admin.service;

import com.kr.kopoctc.planningBridge.admin.entity.Department;
import com.kr.kopoctc.planningBridge.admin.entity.Position;
import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.entity.Guest;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import com.kr.kopoctc.planningBridge.admin.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private GuestRepository guestRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, GuestRepository guestRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.guestRepository = guestRepository;
    }

    @Override
    public void createUser(UserDTO userDTO) {

        Department department = new Department();
        Position position = new Position();

        User user = userDTO.toEntity();
        department.setName(userDTO.getDepartmentPK());
        user.setDepartment(department);

        position.setName(userDTO.getPositionPK());
        user.setPosition(position);

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
