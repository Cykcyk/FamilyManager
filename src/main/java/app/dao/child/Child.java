package app.dao.child;

import java.sql.Date;

public class Child {

    private Long childId;
    private Long familyId;
    private String firstName;
    private String secondName;
    private String pesel;
    private String gender;
    private Date birthDate;

    public Child(Long childId, Long familyId, String firstName, String secondName, String pesel, String gender, Date birthDate) {
        this.childId = childId;
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Child(Long familyId, String firstName, String secondName, String pesel, String gender, Date birthDate) {
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    Child() {
    }

    public Long getFamilyId() {
        return familyId;
    }

    void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    Long getChildId() {
        return childId;
    }

    void setChildId(Long childId) {
        this.childId = childId;
    }

    public String getFirstName() {
        return firstName;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getGender() {
        return gender;
    }

    void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
