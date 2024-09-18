package com.kr.kopoctc.planningBridge.admin.repository;

import com.kr.kopoctc.planningBridge.admin.domain.User;
import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import com.kr.kopoctc.planningBridge.admin.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

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
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount("test01");
        userDTO.setPassword("1234");
        userDTO.setActive(false);
        userDTO.setName("테스트");
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

        userRepository.save(userDTO.toEntity());
    }

    @Test
    void testFindByAccount() {
        Optional<User> found = userRepository.findByAccount("test01");
        assertThat(found).isPresent(); // found가 비어있는지 확인
        assertThat(found.get().getAccount()).isEqualTo("test01");
    }
}
