package com.kr.kopoctc.planningBridge.project.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import com.kr.kopoctc.planningBridge.project.repository.ProjectRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public ProjectEntity saveProject(ProjectDTO projectDTO) {
        ProjectEntity projectEntity = projectDTO.toEntity(null);
        return projectRepository.save(projectEntity);
    }
   /* @Override
    public ProjectEntity saveProject(ProjectDTO projectDTO, String teamMembersJson) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 문자열을 파싱하여 팀 멤버 리스트로 변환
            List<Map<String, String>> teamMembers = objectMapper.readValue(teamMembersJson, List.class);

            // 팀 멤버 정보를 출력
            teamMembers.forEach(member -> {
                log.info("Team: {}, Responsibility: {}, Team Member: {}",
                        member.get("team"),
                        member.get("responsibility"),
                        member.get("teamMember"));
            });

        } catch (JsonProcessingException e) {
            log.error("Failed to parse team members JSON: {}", teamMembersJson, e);
            throw new RuntimeException("Failed to parse team members JSON", e); // 적절한 예외 처리
        }

        // 이후에 프로젝트 저장 로직 실행
        ProjectEntity projectEntity = projectDTO.toEntity(null);
        return projectRepository.save(projectEntity);
    }*/

    // 수정진행중 ..
    @Override
    public void deleteProjectsByIds(List<Long> selectedProjectIds) {
        projectRepository.deleteAllById(selectedProjectIds);
    }



}