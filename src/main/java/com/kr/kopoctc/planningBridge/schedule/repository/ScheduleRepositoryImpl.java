package com.kr.kopoctc.planningBridge.schedule.repository;

import com.kr.kopoctc.planningBridge.schedule.entity.Schedule;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ScheduleRepositoryImpl implements ScheduleRepository {

    @Override
    public <S extends Schedule> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Schedule> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Schedule> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public Iterable<Schedule> findAll() {
        return null;
    }

    @Override
    public Iterable<Schedule> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Schedule entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Schedule> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
