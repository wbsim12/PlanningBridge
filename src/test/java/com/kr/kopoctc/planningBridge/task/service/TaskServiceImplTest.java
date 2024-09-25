package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.admin.dto.UserDTO;
import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.admin.repository.UserRepository;
import com.kr.kopoctc.planningBridge.admin.service.UserService;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import com.kr.kopoctc.planningBridge.task.repository.TaskRepository;
import com.kr.kopoctc.planningBridge.task.repository.TaskRepositoryCustom;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@Transactional
class TaskServiceImplTest {

    @Autowired
    private TaskServiceImpl taskService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskRepositoryCustom taskRepositoryCustom;


    private static final Long EXISTING_USER_PK = 1L;

    @BeforeEach
    void setUp() {
        // 필요한 경우 테스트 데이터 설정
    }

    // 유저 아이디로 유저 찾기
    @Test
    void shouldReturnUserWhenUserPKExists() {
        // When
        User user = taskService.getUserByUserPK(EXISTING_USER_PK);

        // Then
        assertNotNull(user);
        assertEquals(EXISTING_USER_PK, user.getUserPK());
    }

    // 유저 존재 확인 실패테스트
    @Test
    void shouldThrowExceptionWhenUserPKDoesNotExist() {
        // Given
        Long nonExistingUserPK = 999L;

        // When
        User user = taskService.getUserByUserPK(nonExistingUserPK);

        // Then
        assertNull(user);
    }

    // 유저로 프로젝트 번호 리스트 찾기
    @Test
    void shouldReturnProjectPKListForExistingUser() {
        // Given
        User user = taskService.getUserByUserPK(EXISTING_USER_PK);

        // When
        List<Long> projectPKList = taskService.getProjectListPKByUser(user);

        // Then
        assertNotNull(projectPKList);
        assertFalse(projectPKList.isEmpty());
        // 추가적인 검증 로직 (예: 특정 프로젝트 PK가 포함되어 있는지 확인)
    }

    // 프로젝트 번호 리스트로 태스크 객체얻기
    @Test
    void shouldReturnTaskListForGivenProjectPKList() {
        // Given
        User user = taskService.getUserByUserPK(EXISTING_USER_PK);
        List<Long> projectPKList = taskService.getProjectListPKByUser(user);

        // When
        List<Task> taskList = taskService.getTaskByProject(projectPKList);

        // Then
        assertNotNull(taskList);
        assertFalse(taskList.isEmpty());
        // 추가적인 검증 로직 (예: 특정 조건을 만족하는 태스크가 포함되어 있는지 확인)
    }

    @Test
    void getTaskOnlyMine() {
    }

    @Test
    void isProjectAdmin() {
    }

    @Test
    void addTask() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }
}