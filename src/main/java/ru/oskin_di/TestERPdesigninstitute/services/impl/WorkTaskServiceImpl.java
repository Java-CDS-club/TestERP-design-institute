package ru.oskin_di.TestERPdesigninstitute.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
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
        return workTaskRepository.findById(idWorkTask).get();
    }
    //todo проверка optional

    @Override
    public List<WorkTask> findAll() {
        return workTaskRepository.findAll();
    }

    @Override
    @Transactional
    public void saveTask(Employee employeeCreator, String nameWorkTask, int employment_number) {
        WorkTask workTask = new WorkTask();
        workTask.setName(nameWorkTask);
        workTask.setEmployeeCreator(employeeCreator);
        workTask.setEmploymentNumber(employment_number);
        workTaskRepository.save(workTask);
    }

    @Override
    @Transactional
    public int updateTask(Employee employeeExecutor, int idWorkTask) {
        WorkTask workTask = findById(idWorkTask);
        workTask.setEmployeeExecutor(employeeExecutor);
        workTask.setInProgress(true);
        workTaskRepository.save(workTask);
        return workTask.getEmploymentNumber();
    }

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

    @Override
    public void updateTask(WorkTask workTask){
        workTaskRepository.save(workTask);
    };
}
