package app.dao.child;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.*;

@Transactional
@Repository
public class ChildDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ChildDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long addChildToFamily(Child child) {
        String sql = "INSERT INTO child (Family_ID, First_Name, Second_Name, Gender, PESEL, Birth_Date) values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, child.getFamilyId(), child.getFirstName(), child.getSecondName(), child.getGender(), child.getPesel(), child.getBirthDate());

        return child.getChildId();
    }

    public Child getChild(Long id) {
        String sql = "SELECT * FROM child WHERE Child_ID = ?";
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public List<Child> getChildrenList(Long familyId, String firstName, String secondName, String pesel, String birthDate, String gender) {
        RowMapper<Child> rowMapper = new BeanPropertyRowMapper<>(Child.class);
        String query = new ChildQueryBuilder(familyId, firstName, secondName, pesel, birthDate, gender).buildQuery();
        List parameters = new ArrayList();
        if (familyId != null) {
            parameters.add(familyId);
        }
        if (firstName != null && !firstName.isEmpty()) {
            parameters.add(firstName);
        }
        if (secondName != null && !secondName.isEmpty()) {
            parameters.add(secondName);
        }
        if (pesel != null && !pesel.isEmpty()) {
            parameters.add(pesel);
        }
        if (birthDate != null && !birthDate.isEmpty()) {
            parameters.add(Date.valueOf(birthDate));
        }
        if (gender != null && !gender.isEmpty()) {
            parameters.add(gender);
        }
        return jdbcTemplate.query(query, rowMapper, parameters.toArray());
    }
}
