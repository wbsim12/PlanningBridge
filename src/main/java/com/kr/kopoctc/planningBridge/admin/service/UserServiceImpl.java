package com.kr.kopoctc.planningBridge.admin.service;

import com.kr.kopoctc.planningBridge.admin.domain.User;
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
        User user = userDTO.toEntity();
        user.setPassword(passwordEncoder.encode(user.getPassword())); // 비밀번호 인코딩
        return userRepository.save(user);
    }

    @Override
    public User getUserByAccount(String account) {
        return userRepository.findByAccount(account).orElse(null);
    }
}
