package ru.oskin_di.TestERPdesigninstitute.mappers;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ru.oskin_di.TestERPdesigninstitute.models.WorkTask;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class WorkTaskMapper implements RowMapper<WorkTask> {

    @Override
    public WorkTask mapRow(ResultSet rs, int rowNum) throws SQLException {

        WorkTask workTask = new WorkTask();

        workTask.setId(rs.getInt("id"));
        workTask.setName(rs.getString("name"));
        workTask.setInProgress(rs.getBoolean("in_progress"));
        workTask.setIdCreator(rs.getInt("id_creator"));
        workTask.setIdExecutor(rs.getInt("id_executor"));
        workTask.setEmploymentNumber(rs.getInt("employment_number"));

        return workTask;

    }
}
