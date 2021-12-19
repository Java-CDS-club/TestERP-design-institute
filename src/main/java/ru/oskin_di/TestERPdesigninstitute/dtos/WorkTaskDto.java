package ru.oskin_di.TestERPdesigninstitute.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkTaskDto {

    private int id;

    private String name;

    private boolean inProgress;

    private EmployeeDto employeeCreator;

    private EmployeeDto employeeExecutor;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Builder() {
        }

        private final WorkTaskDto workTaskDto = new WorkTaskDto();

        public Builder id(int id) {
            workTaskDto.id = id;
            return this;
        }

        public Builder name(String name) {
            workTaskDto.name = name;
            return this;
        }

        public Builder inProgress(boolean inProgress) {
            workTaskDto.inProgress = inProgress;
            return this;
        }

        public Builder employeeCreator(EmployeeDto employeeCreator) {
            workTaskDto.employeeCreator = employeeCreator;
            return this;
        }

        public Builder employeeExecutor(EmployeeDto employeeExecutor) {
            workTaskDto.employeeExecutor = employeeExecutor;
            return this;
        }

        public WorkTaskDto build() {
            return workTaskDto;
        }

    }
}
