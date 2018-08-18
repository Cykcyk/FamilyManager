package app.dao.family;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FamilyRowMapper implements RowMapper<Family> {

    @Override
    public Family mapRow(ResultSet row, int rowNum) throws SQLException {

        Family family = new Family();
        family.setId(row.getLong("Family_ID"));
        family.setCreationDate(row.getDate("Creation_Date"));
        return family;
    }
}