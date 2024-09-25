package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.task.entity.Task;

import java.util.List;

public interface TaskRepositoryCustom {
    List<Long> getProjectPKByUser(User user);
    List<Task> getTaskListByProjectPKList(List<Long> projectPKList);
    //List<Tuple> getProjectInfoByUser(User user);

}
