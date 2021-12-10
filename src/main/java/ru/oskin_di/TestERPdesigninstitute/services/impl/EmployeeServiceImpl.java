package ru.oskin_di.TestERPdesigninstitute.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;
import ru.oskin_di.TestERPdesigninstitute.repositories.EmployeeRepository;
import ru.oskin_di.TestERPdesigninstitute.services.EmployeeService;
import ru.oskin_di.TestERPdesigninstitute.services.WorkTaskService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WorkTaskService workTaskService;


    @Override
    public Employee findById(int idEmployee) {
        return employeeRepository.findById(idEmployee).get();
    //todo проверка optional
    }

    @Override
    public List<WorkTask> getMyCreatedWorkTask(int idEmployee) {;
        return workTaskService.findWorkTasksByIdEmployeeCreator(idEmployee);
    }

    @Override
    public List<WorkTask> getMyExecutedWorkTask(int idEmployee) {;
        return workTaskService.findWorkTasksByIdEmployeeExecutor(idEmployee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveTask(int idEmployee, String nameWorkTask) {
        Employee employee = findById(idEmployee);
        workTaskService.saveTask(employee,nameWorkTask);
    }

    @Override
    public void updateTask(int idEmployee, int idWorkTask) {
        Employee employee = findById(idEmployee);
        workTaskService.updateTask(employee,idWorkTask);
    }
}
