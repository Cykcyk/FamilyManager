package app.dao.family;

import com.google.common.base.Joiner;

import java.util.Date;

class FamilyQueryBuilder {

    private String childFirstName;
    private String childLastName;
    private String childPesel;
    private Date childBirthDate;
    private String childSex;

    FamilyQueryBuilder(String childFirstName, String childLastName, String childPesel, Date childBirthDate, String childGender) {
        this.childFirstName = childFirstName;
        this.childLastName = childLastName;
        this.childPesel = childPesel;
        this.childBirthDate = childBirthDate;
        this.childSex = childGender;
    }

    String buildQuery() {
        String firstNameQuery = null, lastNameQuery = null, peselQuery = null, birthDateQuery = null, genderQuery = null;

        if (this.childFirstName != null){
            firstNameQuery = "chd.first_name = ?";
        }

        if (this.childLastName != null){
            lastNameQuery = "chd.second_name = :secondName";
        }

        if (this.childPesel != null){
            peselQuery = "chd.pesel = :pesel";
        }

        if (this.childBirthDate != null){
            birthDateQuery = "chd.birth_date = :birthDate";
        }
        if (this.childSex != null){
            genderQuery = "chd.gender = :gender";
        }

        return sql("SELECT fat.first_name, fat.second_name, fat.pesel, fat.birth_date" +
                " FROM family fam JOIN father fat ON fam.family_id = fat.family_id " +
                "JOIN child chd on fam.family_id = chd.family_id" +
                " ", and(firstNameQuery, lastNameQuery, peselQuery, birthDateQuery, genderQuery));
    }

    private String and(String firstNameQuery, String lastNameQuery, String peselQuery, String birthDateQuery, String genderQuery) {
        return Joiner.on(" AND ").skipNulls().join(firstNameQuery, lastNameQuery, peselQuery, birthDateQuery, genderQuery);
    }

    private String sql(String sql, String parameters){
        if(parameters.isEmpty()){
            parameters = null;
        }
        return Joiner.on(" WHERE ").skipNulls().join(sql, parameters);
    }






}
