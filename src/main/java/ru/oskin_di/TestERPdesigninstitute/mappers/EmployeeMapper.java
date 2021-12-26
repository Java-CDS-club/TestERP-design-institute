package ru.oskin_di.TestERPdesigninstitute.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class EmployeeMapper implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

        Employee employee = new Employee();

        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setEmploymentRate(rs.getInt("employment_rate"));

        return employee;
    }
}
