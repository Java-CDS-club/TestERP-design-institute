package ru.oskin_di.TestERPdesigninstitute.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
