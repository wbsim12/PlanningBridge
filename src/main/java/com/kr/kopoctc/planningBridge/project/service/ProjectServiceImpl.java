package com.kr.kopoctc.planningBridge.project.service;

import com.kr.kopoctc.planningBridge.project.dto.ProjectDTO;
import com.kr.kopoctc.planningBridge.project.entity.GuestRequestEntity;
import com.kr.kopoctc.planningBridge.project.entity.ProjectEntity;
import com.kr.kopoctc.planningBridge.project.repository.GuestRequestRepository;
import com.kr.kopoctc.planningBridge.project.repository.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

import static com.kr.kopoctc.planningBridge.project.entity.QProjectEntity.projectEntity;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private static ProjectRepository projectRepository;

    @Autowired
    private GuestRequestRepository guestRequestRepository;



    /*  public ProjectEntity createProject(ProjectDTO projectDTO) {
            GuestRequestEntity guestRequestEntity = guestRequestRepository
                    .findById(projectDTO.getGuestRequestPk())
                    .orElse(null);
            // DTO에서 엔티티로 변환
            ProjectEntity projectEntity = projectDTO.toEntity(guestRequestEntity);
            return projectRepository.save(projectEntity);
        }*/
 /* @Override
  public ProjectEntity createProject(ProjectEntity project) {
      Long sequenceValue = getNextSequenceValue();
      project.setProjectPK("project" + sequenceValue);
      return projectRepository.save(project);
  }

    @Override
    public List<ProjectEntity> findAllProjects() {
        return projectRepository.findAll();
    }

    private Long getNextSequenceValue() {
        BigInteger sequenceValue = (BigInteger) entityManager.createNativeQuery("SELECT nextval('project_seq')").getSingleResult();
        return sequenceValue.longValue();
    }*/
}