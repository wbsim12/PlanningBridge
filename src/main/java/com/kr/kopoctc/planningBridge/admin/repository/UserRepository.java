package com.kr.kopoctc.planningBridge.admin.repository;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
