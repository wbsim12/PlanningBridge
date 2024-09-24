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



    @Test
    void getUserByUserPK() {
        // When
        User user = taskService.getUserByUserPK(1L);
        System.out.println();
        // Then
        assertNotNull(user);
        assertEquals(1L, user.getUserPK());
    }

    @Test
    void getProjectPKByUser() {
        User user = taskService.getUserByUserPK(1L);
        List<Long> projectPKList = taskService.getProjectListPKByUser(user);
        System.out.println("======================");
        System.out.println(projectPKList.toString());
    }

    @Test
    void getTaskByProject() {
        User user = taskService.getUserByUserPK(1L);
        List<Long> projectPKList = taskService.getProjectListPKByUser(user);
        List<Task> taskList = taskRepository.findAllById(projectPKList);
        System.out.println(taskList.toString());
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