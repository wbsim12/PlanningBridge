package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.admin.entity.User;

import java.util.List;

public interface TaskRepositoryCustom {
    List<Long> getProjectPKByUser(User user);
}
