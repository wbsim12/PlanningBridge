package com.kr.kopoctc.planningBridge.task.service;

import com.kr.kopoctc.planningBridge.task.entity.Task;
import com.kr.kopoctc.planningBridge.task.repository.TaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl taskService; // 테스트할 클래스

    @Mock
    private TaskRepository taskRepository; // 의존하는 레포지토리

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Mockito 초기화
    }


    @Test
    void getProjectPKByUser() {

    }

    @Test
    void getTaskByProject() {
        List<Task> result = taskService.getTaskByProject("1");
        System.out.println("=====================");
        System.out.println(result);

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