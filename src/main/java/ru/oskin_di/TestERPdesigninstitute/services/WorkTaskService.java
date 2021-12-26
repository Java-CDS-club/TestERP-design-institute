package ru.oskin_di.TestERPdesigninstitute.services;

import org.springframework.stereotype.Service;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

import java.util.List;

@Service
public interface WorkTaskService {

    WorkTask findById(int idWorkTask);

    List<WorkTask> findAll();

    void saveTask(Employee employeeCreator, String nameWorkTask, int employment_number);

    int updateTask(Employee employeeExecutor, int idWorkTask);

    void updateTask(WorkTask workTask);

    List<WorkTask> findAllInProgress();

    List<WorkTask> findAllNotInProgress();

    List<WorkTask> findWorkTasksByIdEmployeeCreator(int idEmployee);

    List<WorkTask> findWorkTasksByIdEmployeeExecutor(int idEmployee);

    int getCountAllWorkTasksInProgress();

    int getCountAllWorkTasksNotInProgress();

    int getCountAllWorkTasks();

}
