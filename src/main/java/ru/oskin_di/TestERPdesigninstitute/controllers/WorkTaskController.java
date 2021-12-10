package ru.oskin_di.TestERPdesigninstitute.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.oskin_di.TestERPdesigninstitute.dtos.WorkTaskDto;
import ru.oskin_di.TestERPdesigninstitute.services.WorkTaskService;
import ru.oskin_di.TestERPdesigninstitute.utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/work_tasks")
public class WorkTaskController {

    private final WorkTaskService workTaskService;
    private final Converter converter = Converter.getInstance();

    @GetMapping()
    public List<WorkTaskDto> getAllWorkTasksInfo() {
        return workTaskService.findAll().stream().map(converter::workTaskToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public WorkTaskDto getWorkTaskInfo(@PathVariable int id){
        return converter.workTaskToDto(workTaskService.findById(id));
    }

    @GetMapping("/in_progress")
    public List<WorkTaskDto> getWorkTasksInfoInProgress() {
        return workTaskService.findAllInProgress().stream().map(converter::workTaskToDto).collect(Collectors.toList());
    }

    @GetMapping("/not_in_progress")
    public List<WorkTaskDto> getWorkTasksInfoNotInProgress() {
        return workTaskService.findAllNotInProgress().stream().map(converter::workTaskToDto).collect(Collectors.toList());
    }
}
