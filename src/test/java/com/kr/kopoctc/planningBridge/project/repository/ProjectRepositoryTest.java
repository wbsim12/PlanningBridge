package com.kr.kopoctc.planningBridge.project.repository;

import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "spring.main.lazy-initialization=true"
})
public class ProjectRepositoryTest {
    @Autowired
    private ProjectRepository projectRepository;

    @BeforeEach
    public void setUp() {
        // 데이터 삽입
        ProjectEntity project1 = new ProjectEntity();
        project1.setProjectPK("PR001");
        project1.setName("Test Project 1");
        project1.setStartDate(LocalDateTime.now());
        project1.setEndDate(LocalDateTime.now().plusMonths(1));
        project1.setPriority("High");
        project1.setProjectDesc("Description for Test Project 1");

        projectRepository.save(project1); // 저장
    }

    // 프로젝트 조회
    @Test
    public void testFindAllProjects() {
        List<ProjectEntity> projects = projectRepository.findAll();

        // 테스트 검증
        assertNotNull(projects);  // 결과가 null이 아닌지 확인
        assertFalse(projects.isEmpty());  // 데이터가 비어 있지 않은지 확인

        ProjectEntity firstProject = projects.get(0);
        assertNotNull(firstProject.getProjectPK());  // 프로젝트 ID가 null이 아닌지 확인
        assertNotNull(firstProject.getName());  // 프로젝트 이름이 null이 아닌지 확인
    }

    // 프로젝트 삭제
    @Test
    public void testDeleteProject() {
        Optional<ProjectEntity> project = projectRepository.findById("PR001");
        assertTrue(project.isPresent(), "Project should exist before deletion");

        // 프로젝트 삭제
        projectRepository.deleteById("PR001");

        // 삭제 후 다시 조회하여 존재하지 않음을 확인
        Optional<ProjectEntity> deletedProject = projectRepository.findById("PR001");
        assertFalse(deletedProject.isPresent(), "Project should be deleted");
    }


}