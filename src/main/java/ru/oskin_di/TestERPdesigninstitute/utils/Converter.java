package ru.oskin_di.TestERPdesigninstitute.utils;

import ru.oskin_di.TestERPdesigninstitute.dtos.EmployeeDto;
import ru.oskin_di.TestERPdesigninstitute.dtos.StatisticDto;
import ru.oskin_di.TestERPdesigninstitute.dtos.WorkTaskDto;
import ru.oskin_di.TestERPdesigninstitute.models.Employee;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;


public class Converter {

    private Converter() {

    }

    private static Converter converter;
    private static final Object MONITOR = new Object();

    public static Converter getInstance() {
        if (converter == null) {
            synchronized (MONITOR) {
                if (converter == null) {
                    converter = new Converter();
                }
                return converter;
            }
        } else {
            return converter;
        }
    }

    public StatisticDto statisticToDto(int countInProgress, int countNotInProgress, int countAll) {
        return StatisticDto.builder()
                .countInProgress(countInProgress)
                .countNotInProgress(countNotInProgress)
                .countAll(countAll)
                .build();
    }


    public EmployeeDto employeeToDto(Employee employee) {
        if (employee == null) {
            return null;
        }
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();
    }

    public WorkTaskDto workTaskToDto(WorkTask workTask) {
        if (workTask == null) {
            return null;
        }
        return WorkTaskDto.builder()
                .id(workTask.getId())
                .name(workTask.getName())
                .inProgress(workTask.isInProgress())
                .employeeCreator(employeeToDto(workTask.getEmployeeCreator()))
                .employeeExecutor(employeeToDto(workTask.getEmployeeExecutor()))
                .build();
    }
}
