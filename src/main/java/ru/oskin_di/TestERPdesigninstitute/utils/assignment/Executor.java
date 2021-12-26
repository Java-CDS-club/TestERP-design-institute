package ru.oskin_di.TestERPdesigninstitute.utils.assignment;

import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

public abstract class Executor {

    private Executor next;

    public void execute(WorkTask workTask) {

        if (next != null) {
            next.execute(workTask);
        }
    }

    public Executor link(Executor next) {
        this.next = next;
        return next;
    }
}
