package app.dao.child;

import com.google.common.base.Joiner;


class ChildQueryBuilder {

    private Long familyId;
    private String firstName;
    private String secondName;
    private String pesel;
    private String birthDate;
    private String gender;

    ChildQueryBuilder(Long familyId, String firstName, String secondName, String pesel, String birthDate, String gender) {
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    String buildQuery() {
        String familyIdQuery = null, firstNameQuery = null, secondNameQuery = null, peselQuery = null, birthDateQuery = null, genderQuery = null;

        if (this.familyId != null) {
            familyIdQuery = "family_id = ?";
        }

        if (this.firstName != null && !this.firstName.isEmpty()) {
            firstNameQuery = "first_name = ?";
        }

        if (this.secondName != null && !this.secondName.isEmpty()) {
            secondNameQuery = "second_name = ?";
        }

        if (this.pesel != null && !this.pesel.isEmpty()) {
            peselQuery = "pesel = ?";
        }

        if (this.birthDate != null && !this.birthDate.isEmpty()) {
            birthDateQuery = "birth_date = ?";
        }

        if (this.gender != null && !this.gender.isEmpty()) {
            genderQuery = "gender = ?";
        }

        return sql("SELECT * FROM child ", and(familyIdQuery, firstNameQuery, secondNameQuery, peselQuery, birthDateQuery, genderQuery));
    }

    private String and(String familyIdQuery, String firstNameQuery, String lastNameQuery, String peselQuery, String birthDateQuery, String genderQuery) {
        return Joiner.on(" AND ").skipNulls().join(familyIdQuery, firstNameQuery, lastNameQuery, peselQuery, birthDateQuery, genderQuery);
    }

    private String sql(String sql, String parameters) {
        if (parameters.isEmpty()) {
            parameters = null;
        }
        return Joiner.on(" WHERE ").skipNulls().join(sql, parameters);
    }


}



