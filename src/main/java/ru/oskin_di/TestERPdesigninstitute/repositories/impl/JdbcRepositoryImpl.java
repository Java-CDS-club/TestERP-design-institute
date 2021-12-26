package ru.oskin_di.TestERPdesigninstitute.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.repositories.JdbcRepository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;


@Repository
@RequiredArgsConstructor
public class JdbcRepositoryImpl implements JdbcRepository {

    private final DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initJdbcTemplate() {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

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
