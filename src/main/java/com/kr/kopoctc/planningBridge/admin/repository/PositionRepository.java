package com.kr.kopoctc.planningBridge.admin.repository;

import com.kr.kopoctc.planningBridge.admin.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Integer> {

}
