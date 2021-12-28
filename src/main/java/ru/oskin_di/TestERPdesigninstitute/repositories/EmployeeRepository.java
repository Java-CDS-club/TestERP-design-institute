package ru.oskin_di.TestERPdesigninstitute.repositories;

import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;

import java.util.List;


@Repository
public interface EmployeeRepository {

    List<Employee> findAll();

    Employee findById(int id);

    void update(int id, int employment_rate);

}
