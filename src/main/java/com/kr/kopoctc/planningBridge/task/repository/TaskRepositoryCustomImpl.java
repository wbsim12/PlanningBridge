package com.kr.kopoctc.planningBridge.task.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import static com.kr.kopoctc.planningBridge.project.entity.QProjectTeamEntity.projectTeamEntity;
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

    //admin 쪽 userPK 와 projectTeam 의 userPK가 이어져있지 않아서 오류남. 두 변수의 데이터 타입도 다름.
/*
    @Override
    public List<String> getProjectPKByUserPK(int userPK) {
        return jpaQueryFactory
                .select(projectTeamEntity.projectTeamPK)
                .from(projectTeamEntity)
                .where(projectTeamEntity.userPK.eq(userPK))
                .fetch();
    }
*/

}
