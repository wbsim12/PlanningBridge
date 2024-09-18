package com.kr.kopoctc.planningBridge.admin.config;

import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;
import com.kr.kopoctc.planningBridge.admin.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
//@Profile("!test")
@Slf4j
public class DataLoader {

    private final UserServiceImpl userServiceImpl;

    public DataLoader(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // 더미 데이터 생성 및 저장
            UserDTO userDTO = new UserDTO();
            userDTO.setAccount("kopo06");
            userDTO.setPassword("1234");
            userDTO.setActive(false);
            userDTO.setName("김선우");
            userDTO.setPhoneNumber("010-4315-1158");
            userDTO.setEmail("kopo06@gmail.com");
            userDTO.setDepartmentPK("DEPT001");
            userDTO.setPositionPK("POS001");
            userDTO.setLastChanagedPassword(LocalDate.now());
            userDTO.setPasswordExpired(false);
            userDTO.setCheckAdmin(false);
            userDTO.setCheckGuest(false);
            userDTO.setCreatedDate(LocalDate.now());
            userDTO.setUpdatedDate(LocalDate.now());

            userServiceImpl.createUser(userDTO);

            userDTO = new UserDTO();

            userDTO.setAccount("admin");
            userDTO.setPassword("root");
            userDTO.setActive(false);
            userDTO.setName("관리자");
            userDTO.setPhoneNumber("010-1234-5678");
            userDTO.setEmail("admin@gmail.com");
            userDTO.setDepartmentPK("DEPT002");
            userDTO.setPositionPK("POS002");
            userDTO.setLastChanagedPassword(LocalDate.now());
            userDTO.setPasswordExpired(false);
            userDTO.setCheckAdmin(true);
            userDTO.setCheckGuest(false);
            userDTO.setCreatedDate(LocalDate.now());
            userDTO.setUpdatedDate(LocalDate.now());

            userServiceImpl.createUser(userDTO);

            log.info("DataLoader 실행");
        };
    }
}
