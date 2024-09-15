package com.kr.kopoctc.planningBridge.admin.repository;

import com.kr.kopoctc.planningBridge.admin.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.main.lazy-initialization=true"
})
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // 테스트 데이터 초기화
        User user = new User();
        user.setAccount("test01");
        user.setEmail("test01@example.com");
        user.setStatus(true);
        userRepository.save(user);
        log.info("Test Setup 실행");
    }

    @Test
    void testFindByAccount() {
        Optional<User> found = userRepository.findByAccount("test01");
        assertThat(found).isPresent(); // found가 비어있는지 확인
        assertThat(found.get().getAccount()).isEqualTo("test01");
    }
}
