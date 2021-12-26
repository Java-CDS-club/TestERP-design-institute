package ru.oskin_di.TestERPdesigninstitute.repositories.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.mappers.EmployeeMapper;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.repositories.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final String SQL_FIND_ALL = "SELECT * FROM employees";
    private final String SQL_FIND_BY_ID = "SELECT * FROM employees WHERE id = ?";
    private final String SQL_UPDATE_BY_ID = "UPDATE employees SET employment_rate = ? WHERE id = ?";
    private final Map<Integer, Employee> identityMap = new HashMap<>();
    private final EmployeeMapper employeeMapper;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public List<Employee> findAll() {
        identityMap.clear();
        List<Employee> employees = jdbcTemplate.query(SQL_FIND_ALL, employeeMapper);
        employees.forEach(employee -> identityMap.put(employee.getId(), employee));
        return employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = identityMap.get(id);
        if (employee == null) {
            employee = jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{id}, employeeMapper);
            if (employee != null) {
                identityMap.put(id, employee);
            }
        }
        return employee;
    }

    @Override
    public void update(int id, int employment_rate) {
        jdbcTemplate.update(SQL_UPDATE_BY_ID, employment_rate, id);
    }
}
