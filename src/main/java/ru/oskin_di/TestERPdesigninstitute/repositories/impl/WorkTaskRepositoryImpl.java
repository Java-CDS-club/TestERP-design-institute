package ru.oskin_di.TestERPdesigninstitute.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.mappers.WorkTaskMapper;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;
import ru.oskin_di.TestERPdesigninstitute.repositories.WorkTaskRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class WorkTaskRepositoryImpl implements WorkTaskRepository {

    private final String SQL_FIND_ALL = "SELECT * FROM work_tasks";
    private final String SQL_FIND_BY_ID = "SELECT * FROM work_tasks WHERE id = ?";
    private final String SQL_FIND_ALL_BY_IN_PROGRESS = "SELECT * FROM work_tasks WHERE in_progress = ?";
    private final String SQL_FIND_ALL_BY_ID_CREATOR = "SELECT * FROM work_tasks WHERE id_creator = ?";
    private final String SQL_FIND_ALL_BY_ID_EXECUTOR = "SELECT * FROM work_tasks WHERE id_executor = ?";
    private final String SQL_SAVE = "INSERT INTO work_tasks (name, id_creator, employment_number) VALUES (?, ?, ?)";
    private final String SQL_UPDATE = "UPDATE work_tasks SET id_executor = ?, in_progress = ? WHERE id = ?";
    private final JdbcTemplate jdbcTemplate;
    private final WorkTaskMapper workTaskMapper;
    private final Map<Integer, WorkTask> identityMap = new HashMap<>();

    @Override
    public List<WorkTask> findAll() {
        identityMap.clear();
        List<WorkTask> workTasks = jdbcTemplate.query(SQL_FIND_ALL, workTaskMapper);
        workTasks.forEach(workTask -> identityMap.put(workTask.getId(), workTask));
        return workTasks;
    }

    @Override
    public WorkTask findById(int id) {
        WorkTask workTask = identityMap.get(id);
        if (workTask == null) {
            workTask = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, workTaskMapper);
            if (workTask != null) {
                identityMap.put(id, workTask);
            }
        }
        return workTask;
    }


    @Override
    public void save(WorkTask workTask) {
        jdbcTemplate.update(SQL_SAVE, workTask.getName(), workTask.getIdCreator(), workTask.getEmploymentNumber());
    }

    @Override
    public void update(int idExecutor, int idWorkTask) {
        WorkTask workTask = identityMap.get(idWorkTask);
        if (workTask != null) {
            workTask.setIdExecutor(idExecutor);
            workTask.setInProgress(true);
        }
        jdbcTemplate.update(SQL_UPDATE, idExecutor, true, idWorkTask);
    }

    @Override
    public void update(WorkTask workTask) {
        jdbcTemplate.update(SQL_UPDATE, workTask.getIdExecutor(), true, workTask.getId());
    }

    @Override
    public List<WorkTask> findAllByInProgress(boolean inProgress) {
        return getWorkTasks(jdbcTemplate.query(SQL_FIND_ALL_BY_IN_PROGRESS, workTaskMapper, inProgress), inProgress);
    }

    @Override
    public List<WorkTask> findWorkTasksByIdEmployeeCreator(int id) {
        return getWorkTasks(jdbcTemplate.query(SQL_FIND_ALL_BY_ID_CREATOR, workTaskMapper, id), id);
    }

    @Override
    public List<WorkTask> findWorkTasksByIdEmployeeExecutor(int id) {
        return getWorkTasks(jdbcTemplate.query(SQL_FIND_ALL_BY_ID_EXECUTOR, workTaskMapper, id), id);
    }

    private List<WorkTask> getWorkTasks(List<WorkTask> query, Object... args) {
        query.forEach(workTask -> {
            if (identityMap.get(workTask.getId()) != null) {
                identityMap.remove(workTask.getId());
            }
            identityMap.put(workTask.getId(), workTask);
        });
        return query;
    }
}
