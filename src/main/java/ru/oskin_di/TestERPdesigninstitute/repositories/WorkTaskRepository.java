package ru.oskin_di.TestERPdesigninstitute.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

import java.util.List;

@Repository
public interface WorkTaskRepository extends JpaRepository<WorkTask, Integer> {

    @EntityGraph(value = "work_tasks.for-front")
    List<WorkTask> findAll();

    @EntityGraph(value = "work_tasks.for-front")
    List<WorkTask> findAllByInProgress(boolean inProgress);

    @Query("select w from WorkTask w where w.employeeCreator.id = :id")
    @EntityGraph(value = "work_tasks.for-front")
    List<WorkTask> findWorkTasksByIdEmployeeCreator(int id);

    @Query("select w from WorkTask w where w.employeeExecutor.id = :id")
    @EntityGraph(value = "work_tasks.for-front")
    List<WorkTask> findWorkTasksByIdEmployeeExecutor(int id);

}
