package ru.oskin_di.TestERPdesigninstitute.repositories;

import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

import java.util.List;

@Repository
public interface WorkTaskRepository {

    List<WorkTask> findAll();

    WorkTask findById(int id);

    void save(WorkTask workTask);

    void update(int idExecutor, int idWorkTask);

    void update(WorkTask workTask);

    List<WorkTask> findAllByInProgress(boolean inProgress);

    List<WorkTask> findWorkTasksByIdEmployeeCreator(int id);

    List<WorkTask> findWorkTasksByIdEmployeeExecutor(int id);

}
