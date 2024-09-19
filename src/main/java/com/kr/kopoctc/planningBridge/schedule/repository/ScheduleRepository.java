package com.kr.kopoctc.planningBridge.schedule.repository;

import com.kr.kopoctc.planningBridge.schedule.entity.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, String> {

}
