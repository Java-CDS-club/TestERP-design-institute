package ru.oskin_di.TestERPdesigninstitute.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;
import ru.oskin_di.TestERPdesigninstitute.repositories.EmployeeRepository;
import ru.oskin_di.TestERPdesigninstitute.services.EmployeeService;
import ru.oskin_di.TestERPdesigninstitute.services.WorkTaskService;
import ru.oskin_di.TestERPdesigninstitute.utils.assignment.BusyExecutor;
import ru.oskin_di.TestERPdesigninstitute.utils.assignment.Executor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final WorkTaskService workTaskService;


    @Override
    public Employee findById(int idEmployee) {
        return employeeRepository.findById(idEmployee);
    }

    @Override
    public List<WorkTask> getMyCreatedWorkTask(int idEmployee) {
        return workTaskService.findWorkTasksByIdEmployeeCreator(idEmployee);
    }

    @Override
    public List<WorkTask> getMyExecutedWorkTask(int idEmployee) {
        return workTaskService.findWorkTasksByIdEmployeeExecutor(idEmployee);
    }

    @Override
    @Transactional
    public void distributeTask(int idWorkTask) {
        WorkTask workTask = workTaskService.findById(idWorkTask);
        Executor executor = new BusyExecutor();
        List<Employee> employees = findAll();
        createLink(executor, employees);
        executor.execute(workTask);
        Employee employee = findById(workTask.getIdExecutor());
        System.out.println(employee.getEmploymentRate());
        employeeRepository.update(employee.getId(), employee.getEmploymentRate());
        workTaskService.updateTask(workTask);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveTask(int idEmployee, String nameWorkTask, int employment_number) {
        Employee employee = findById(idEmployee);
        workTaskService.saveTask(employee.getId(), nameWorkTask, employment_number);
    }

    @Override
    public void updateTask(int idEmployee, int idWorkTask) {
        Employee employee = findById(idEmployee);
        employee.setEmploymentRate(workTaskService.updateTask(employee.getId(), idWorkTask));
        employeeRepository.update(idEmployee, employee.getEmploymentRate());
    }

    private void createLink(Executor executor, List<Employee> employees) {
        for (int i = employees.size() - 1; i > 0; i--) {
            employees.get(i - 1).link(employees.get(i));
        }
        executor.link(employees.get(0));
        employees.get(employees.size() - 1).link(executor);
    }
}
