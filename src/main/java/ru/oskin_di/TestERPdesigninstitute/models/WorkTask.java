package ru.oskin_di.TestERPdesigninstitute.models;

import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
public class WorkTask {

    private int id;

    private String name;

    private boolean inProgress;

    private int idCreator;

    private int idExecutor;

    private int employmentNumber;

}
