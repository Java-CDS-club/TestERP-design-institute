package ru.oskin_di.TestERPdesigninstitute.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.repositories.JdbcRepository;


@Repository
@RequiredArgsConstructor
public class JdbcRepositoryImpl implements JdbcRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public int getCountInProgressWorkTasks() {
        return jdbcTemplate.queryForObject(
                "select count(*) from work_tasks where in_progress = true", Integer.class);
    }

    @Override
    public int getCountNotInProgressWorkTasks() {
        return jdbcTemplate.queryForObject(
                "select count(*) from work_tasks where in_progress = false", Integer.class);
    }

    @Override
    public int getCountWorkTasks() {
        return jdbcTemplate.queryForObject(
                "select count(*) from work_tasks", Integer.class);
    }
}
