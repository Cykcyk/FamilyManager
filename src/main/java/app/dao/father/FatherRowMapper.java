package app.dao.father;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class FatherRowMapper implements RowMapper <Father>{

    @Override
    public Father mapRow(ResultSet row, int rowNum) throws SQLException{
        Father father = new Father();
        father.setFatherId(row.getLong("Father_ID"));
        father.setFamilyId(row.getLong("Family_ID"));
        father.setFirstName(row.getString("First_Name"));
        father.setSecondName(row.getString("Second_Name"));
        father.setPesel(row.getString("PESEL"));
        father.setBirthDate(row.getDate("Birth_Date"));
        return father;
    }

}
