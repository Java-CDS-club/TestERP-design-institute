package ru.oskin_di.TestERPdesigninstitute.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface JdbcRepository {

    int getCountInProgressWorkTasks();

    int getCountNotInProgressWorkTasks();

    int getCountWorkTasks();

}
