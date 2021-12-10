package ru.oskin_di.TestERPdesigninstitute.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.oskin_di.TestERPdesigninstitute.dtos.EmployeeDto;
import ru.oskin_di.TestERPdesigninstitute.dtos.WorkTaskDto;
import ru.oskin_di.TestERPdesigninstitute.services.EmployeeService;
import ru.oskin_di.TestERPdesigninstitute.utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final Converter converter = Converter.getInstance();

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeInfo(@PathVariable int id) {
        return converter.employeeToDto(employeeService.findById(id));
    }

    @GetMapping("/all")
    public List<EmployeeDto> getAllEmployeesInfo() {
        return employeeService.findAll().stream().map(converter::employeeToDto).collect(Collectors.toList());
    }

    @PostMapping("/{id}")
    public ResponseEntity<String> addTask(@RequestParam String nameWorkTask, @PathVariable int id) {
        employeeService.saveTask(id, nameWorkTask);
        return new ResponseEntity<String>("Задача поставлена", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> takeTask(@RequestParam int idWorkTask, @PathVariable int id) {
        employeeService.updateTask(id,idWorkTask);
        return new ResponseEntity<String>("Задача взята в работу", HttpStatus.OK);
    }

    @GetMapping("/{id}/my_created_task")
    public List<WorkTaskDto> getMyCreatedTask(@PathVariable int id){
        return employeeService.getMyCreatedWorkTask(id).stream().map(converter::workTaskToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}/my_executed_task")
    public List<WorkTaskDto> getMyExecutedTask(@PathVariable int id){
        return employeeService.getMyExecutedWorkTask(id).stream().map(converter::workTaskToDto).collect(Collectors.toList());
    }

}
