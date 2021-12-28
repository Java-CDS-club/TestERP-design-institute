package ru.oskin_di.TestERPdesigninstitute.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.oskin_di.TestERPdesigninstitute.utils.assignment.Executor;

@Data
@NoArgsConstructor
public class Employee extends Executor {

    private int id;

    private String name;

    private int employmentRate;

    @Override
    public void execute(WorkTask workTask) {
        if (isBusy()) {
            super.execute(workTask);
        } else {
            employmentRate = employmentRate + workTask.getEmploymentNumber();
            workTask.setIdExecutor(id);
        }
    }

    private boolean isBusy() {
        return employmentRate > 20;
    }


}
