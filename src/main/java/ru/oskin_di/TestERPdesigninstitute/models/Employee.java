package ru.oskin_di.TestERPdesigninstitute.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.oskin_di.TestERPdesigninstitute.utils.assignment.Executor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "employees")
public class Employee extends Executor {

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

    @Column(name = "employment_rate")
    private int employmentRate;

    @Override
    public void execute(WorkTask workTask) {
        if (isBusy()) {
            System.out.printf("Employee %s is busy\n", name);
            super.execute(workTask);
        } else {
            System.out.printf("Employee %s is processing Request %s\n",
                    name, workTask.getEmploymentNumber());
            employmentRate += workTask.getEmploymentNumber();
            listOfExecutedTasks.add(workTask);
            /// TODO: Меняет коэффициент занятости, но новую задачу в базу не прокидывает, нужно будет подумать, как это красиво сделать */
        }
    }

    private boolean isBusy() {
        return employmentRate > 20;
    }


}
