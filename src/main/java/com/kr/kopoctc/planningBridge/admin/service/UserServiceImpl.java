package com.kr.kopoctc.planningBridge.admin.service;

import com.kr.kopoctc.planningBridge.admin.entity.Department;
import com.kr.kopoctc.planningBridge.admin.entity.Position;
import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(UserDTO userDTO) {

        Department department = new Department();
        Position position = new Position();

        User user = userDTO.toEntity();
        department.setName(userDTO.getDepartment_name());
        user.setDepartment(department);

        position.setName(userDTO.getPosition_name());
        user.setPosition(position);

        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 인코딩
        return userRepository.save(user);
    }

    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account).orElse(null);
    }
}
