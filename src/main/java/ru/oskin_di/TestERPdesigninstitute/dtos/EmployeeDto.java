package ru.oskin_di.TestERPdesigninstitute.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class EmployeeDto {

    private int id;

    private String name;

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Builder() {
        }

        private final EmployeeDto employeeDto = new EmployeeDto();

        public Builder id(int id){
            employeeDto.id = id;
            return this;
        }

        public Builder name(String name){
            employeeDto.name = name;
            return this;
        }

        public EmployeeDto build(){
            return employeeDto;
        }
    }
}
