package ru.oskin_di.TestERPdesigninstitute.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StatisticDto {

    private int countInProgress;

    private int countNotInProgress;

    private int countAll;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Builder() {
        }

        private final StatisticDto statisticDto = new StatisticDto();

        public Builder countInProgress(int countInProgress) {
            statisticDto.countInProgress = countInProgress;
            return this;
        }

        public Builder countNotInProgress(int countNotInProgress) {
            statisticDto.countNotInProgress = countNotInProgress;
            return this;
        }

        public Builder countAll(int countAll) {
            statisticDto.countAll = countAll;
            return this;
        }

        public StatisticDto build() {
            return statisticDto;
        }
    }
}
