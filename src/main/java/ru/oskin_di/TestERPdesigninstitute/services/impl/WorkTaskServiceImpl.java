package ru.oskin_di.TestERPdesigninstitute.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;
import ru.oskin_di.TestERPdesigninstitute.repositories.JdbcRepository;
import ru.oskin_di.TestERPdesigninstitute.repositories.WorkTaskRepository;
import ru.oskin_di.TestERPdesigninstitute.services.WorkTaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkTaskServiceImpl implements WorkTaskService {

    private final WorkTaskRepository workTaskRepository;
    private final JdbcRepository jdbcRepository;

    @Override
    public WorkTask findById(int idWorkTask) {
        return workTaskRepository.findById(idWorkTask);
    }

    @Override
    public List<WorkTask> findAll() {
        return workTaskRepository.findAll();
    }

    @Override
    public void saveTask(int idEmployee, String nameWorkTask, int employment_number) {
        WorkTask workTask = new WorkTask();
        workTask.setName(nameWorkTask);
        workTask.setIdCreator(idEmployee);
        workTask.setEmploymentNumber(employment_number);
        workTaskRepository.save(workTask);
    }

    @Override
    public int updateTask(int idEmployee, int idWorkTask) {
        workTaskRepository.update(idEmployee, idWorkTask);
        return findById(idWorkTask).getEmploymentNumber();
    }

    @Override
    public void updateTask(WorkTask workTask) {
        workTaskRepository.update(workTask);
    }

    ;

    @Override
    public List<WorkTask> findWorkTasksByIdEmployeeCreator(int idEmployee) {
        return workTaskRepository.findWorkTasksByIdEmployeeCreator(idEmployee);
    }

    @Override
    public List<WorkTask> findWorkTasksByIdEmployeeExecutor(int idEmployee) {
        return workTaskRepository.findWorkTasksByIdEmployeeExecutor(idEmployee);
    }

    @Override
    public int getCountAllWorkTasksInProgress() {
        return jdbcRepository.getCountInProgressWorkTasks();
    }

    @Override
    public int getCountAllWorkTasksNotInProgress() {
        return jdbcRepository.getCountNotInProgressWorkTasks();
    }

    @Override
    public int getCountAllWorkTasks() {
        return jdbcRepository.getCountWorkTasks();
    }

    @Override
    public List<WorkTask> findAllInProgress() {
        return workTaskRepository.findAllByInProgress(true);
    }

    @Override
    public List<WorkTask> findAllNotInProgress() {
        return workTaskRepository.findAllByInProgress(false);
    }


}
