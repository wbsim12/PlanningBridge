package com.kr.kopoctc.planningBridge.admin.config;

import com.kr.kopoctc.planningBridge.admin.domain.User;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;

@Configuration
//@Profile("!test")
@Slf4j
public class DataLoader {
    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return args -> {
            // 기존 데이터를 모두 삭제 (선택사항)
            userRepository.deleteAll();

            // 더미 데이터 생성 및 저장
            User user1 = new User();
            user1.setAccount("user1");
            user1.setPassword("password1");
            user1.setEmail("user1@example.com");
            user1.setContactInfo("010-1234-5678");
            user1.setJoinDate(LocalDate.now());
            user1.setName("User One");
            user1.setStatus(true);
            user1.setLastChanagedPassword(LocalDate.now());
            user1.setPasswordExpired(false);
            user1.setCheckAdmin(false);
            user1.setCheckGuest(false);
            user1.setDepartmentPK("DEPT001");
            user1.setPositionPK("POS001");
            user1.setCreatedDate(LocalDate.now());
            user1.setUpdatedDate(LocalDate.now());
            userRepository.save(user1);

            User user2 = new User();
            user2.setAccount("admin1");
            user2.setPassword("adminpass");
            user2.setEmail("admin@example.com");
            user2.setContactInfo("010-9876-5432");
            user2.setJoinDate(LocalDate.now());
            user2.setName("Admin User");
            user2.setStatus(true);
            user2.setLastChanagedPassword(LocalDate.now().minusDays(15));
            user2.setPasswordExpired(false);
            user2.setCheckAdmin(true);
            user2.setCheckGuest(false);
            user2.setDepartmentPK("DEPT002");
            user2.setPositionPK("POS002");
            user2.setCreatedDate(LocalDate.now());
            user2.setUpdatedDate(LocalDate.now());

            userRepository.save(user2);

            User user3 = new User();
            user3.setAccount("test01");
            user3.setPassword("testpassword");
            user3.setEmail("test@example.com");
            user3.setContactInfo("010-4315-1158");
            user3.setJoinDate(LocalDate.now());
            user3.setName("test user");
            user3.setStatus(true);
            user3.setLastChanagedPassword(LocalDate.now());
            user3.setPasswordExpired(false);
            user3.setCheckAdmin(false);
            user3.setCheckGuest(false);
            user3.setDepartmentPK("DEPT003");
            user3.setPositionPK("POS003");
            user3.setCreatedDate(LocalDate.now());
            user3.setUpdatedDate(LocalDate.now());

            userRepository.save(user3);

            log.info("DataLoader 실행");
        };
    }
}
