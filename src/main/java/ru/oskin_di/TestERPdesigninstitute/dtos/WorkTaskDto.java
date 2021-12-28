package ru.oskin_di.TestERPdesigninstitute.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkTaskDto {

    private int id;

    private String name;

    private boolean inProgress;

    private int idCreator;

    private int idExecutor;

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

        public Builder idCreator(int idCreator) {
            workTaskDto.idCreator = idCreator;
            return this;
        }

        public Builder idExecutor(int idExecutor) {
            workTaskDto.idExecutor = idExecutor;
            return this;
        }

        public WorkTaskDto build() {
            return workTaskDto;
        }

    }
}
