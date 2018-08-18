package app.dao.father;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Repository
public class FatherDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FatherDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long addFatherToFamily(Father father) {
        String sql = "INSERT INTO father (Family_ID, First_Name, Second_Name, PESEL, Birth_Date) values (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, father.getFamilyId(), father.getFirstName(), father.getSecondName(), father.getPesel(), father.getBirthDate());

        return father.getFatherId();
    }

    public Father getFather(Long id) {
        String sql = "SELECT * FROM father WHERE father_ID = ?";
        RowMapper<Father> rowMapper = new BeanPropertyRowMapper<>(Father.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public Father getFatherByFamilyId(Long familyId) {
        String sql = "SELECT * FROM father WHERE family_ID = ?";
        RowMapper<Father> rowMapper = new BeanPropertyRowMapper<>(Father.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, familyId);
    }

}
