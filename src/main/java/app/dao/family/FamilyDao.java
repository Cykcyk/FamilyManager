package app.dao.family;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.SQLException;
import java.util.*;

@Transactional
@Repository
public class FamilyDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FamilyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Family getFamily(Long id) {
        String sql = "SELECT Family_ID FROM family WHERE Family_ID = ?";
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Long createFamily(Family family) {
        Date actualDate = new Date(Calendar.getInstance().getTime().getTime());
        family.setCreationDate(actualDate);
        String sql = "INSERT INTO family (Creation_Date) values(?)";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        String id_column = "Family_ID";
        jdbcTemplate.update(con -> {
                    java.sql.PreparedStatement ps = con.prepareStatement(sql, new String[]{id_column});
                    ps.setDate(1, family.getCreationDate());
                    return ps;
                }
                , keyHolder);
        return (Long) keyHolder.getKey();
    }

    public List<Family> getFamilyList(String childFirstName, String childSecondName, String childPesel, Date childBirthDate, String childGender) {
        RowMapper<Family> rowMapper = new BeanPropertyRowMapper<>(Family.class);
        String query = new FamilyQueryBuilder(childFirstName, childSecondName, childPesel, childBirthDate, childGender).buildQuery();
        Map<String, Object> params = new HashMap<>();
        if (childFirstName != null) {
            params.put("first_name", childFirstName);
        }
        if (childSecondName != null) {
            params.put("second_name", childSecondName);
        }
        if (childPesel != null) {
            params.put("pesel", childPesel);
        }
        if (childBirthDate != null) {
            params.put("birth_Date", childBirthDate);
        }
        if (childGender != null) {
            params.put("gender", childGender);
        }
        return jdbcTemplate.query(query, rowMapper, params);
    }
}
