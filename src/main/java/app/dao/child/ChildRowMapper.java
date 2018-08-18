package app.dao.child;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChildRowMapper implements RowMapper<Child> {

    @Override
    public Child mapRow(ResultSet row, int rowNum) throws SQLException {
        Child child = new Child();
        child.setChildId(row.getLong("Child_ID"));
        child.setFamilyId(row.getLong("Family_ID"));
        child.setFirstName(row.getString("First_Name"));
        child.setSecondName(row.getString("Second_Name"));
        child.setPesel(row.getString("PESEL"));
        child.setGender(row.getString("Gender"));
        child.setBirthDate(row.getDate("Birth_Date"));

        return child;
    }
}
