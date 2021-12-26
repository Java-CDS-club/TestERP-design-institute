package ru.oskin_di.TestERPdesigninstitute.utils.assignment;

import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

public class BusyExecutor extends Executor {

    private WorkTask workTask;

    @Override
    public void execute(WorkTask workTask) {
        if (this.workTask != workTask) {
            this.workTask = workTask;
        }
        super.execute(workTask);
    }
}
