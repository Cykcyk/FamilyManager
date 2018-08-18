package app.childDTO;

import app.dao.child.Child;

import java.sql.Date;

public class ChildDTO {

    private Long familyId;
    private String firstName;
    private String secondName;
    private String pesel;
    private String gender;
    private Date birthDate;

    public ChildDTO(Child i) {
        this.familyId = i.getFamilyId();
        this.firstName = i.getFirstName();
        this.secondName = i.getSecondName();
        this.pesel = i.getPesel();
        this.gender = i.getGender();
        this.birthDate = i.getBirthDate();
    }


    public Long getFamilyId() {
        return familyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public ChildDTO() {
    }

    public ChildDTO(Long familyId, String firstName, String secondName, String pesel, String gender, Date birthDate) {
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.gender = gender;
        this.birthDate = birthDate;
    }
}
