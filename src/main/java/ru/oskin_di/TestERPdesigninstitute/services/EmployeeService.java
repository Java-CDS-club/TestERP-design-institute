package ru.oskin_di.TestERPdesigninstitute.services;

import org.springframework.stereotype.Service;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

import java.util.List;

@Service
public interface EmployeeService {

    Employee findById(int idEmployee);

    List<Employee> findAll();

    void saveTask(int idEmployee, String nameWorkTask, int employment_number);

    void updateTask(int idEmployee, int idWorkTask);

    List<WorkTask> getMyCreatedWorkTask(int idEmployee);

    List<WorkTask> getMyExecutedWorkTask(int idEmployee);

    void distributeTask(int idWorkTask);

}
