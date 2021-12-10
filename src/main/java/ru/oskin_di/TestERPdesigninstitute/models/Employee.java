package ru.oskin_di.TestERPdesigninstitute.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employeeCreator", cascade = CascadeType.ALL)
    private List<WorkTask> listOfCreatedTasks;

    @OneToMany(mappedBy = "employeeExecutor", cascade = CascadeType.ALL)
    private List<WorkTask> listOfExecutedTasks;

}
