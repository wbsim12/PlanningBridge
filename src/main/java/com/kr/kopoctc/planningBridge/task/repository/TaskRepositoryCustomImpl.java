package com.kr.kopoctc.planningBridge.task.repository;

import com.kr.kopoctc.planningBridge.admin.entity.User;
import com.kr.kopoctc.planningBridge.task.entity.Task;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.kr.kopoctc.planningBridge.project.entity.QProjectTeam.projectTeam;
import static com.kr.kopoctc.planningBridge.task.entity.QTask.task;
import java.util.List;

@Repository
public class TaskRepositoryCustomImpl implements TaskRepositoryCustom{

    @Autowired
    private JPAQueryFactory jpaQueryFactory;


    //예시.

   /* @Override
    public List<BoardItem> getAll() {
        return jpaQueryFactory
                .selectFrom(boardItem)
                .join(boardItem.userItem, userItem).fetchJoin()
                .fetch();
    }

        @Override
        public List<String> getAllStatuses() {
            return jpaQueryFactory
                    .select(boardItem.status)  // 특정 컬럼 선택
                    .from(boardItem)
                    .fetch()
                */


    @Override
    public List<Long> getProjectPKByUser(User user) {
        return jpaQueryFactory
                .select(projectTeam.projectTeamPK)
                .from(projectTeam)
                .where(projectTeam.userPK.eq(user))
                .fetch();
    }

    @Override
    public List<Task> getTaskListByProjectPKList(List<Long> projectPKList) {
        return jpaQueryFactory
                .select(task)
                .from(task)
                .where(task.project.projectPK.in(projectPKList))
                .fetch();
    }


}
