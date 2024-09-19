package com.kr.kopoctc.planningBridge.admin.service;


import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;

public interface UserService {
    User createUser(UserDTO userDTO);
    User getUserByAccount(String account);

}
