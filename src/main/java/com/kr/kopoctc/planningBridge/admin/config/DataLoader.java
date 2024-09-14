package com.kr.kopoctc.planningBridge.admin.config;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
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

            // 필요한 만큼 더미 데이터를 추가할 수 있습니다.
        };
    }
}
