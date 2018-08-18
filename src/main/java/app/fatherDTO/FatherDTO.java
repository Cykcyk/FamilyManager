package app.fatherDTO;

import app.dao.father.Father;

import java.util.Date;

public class FatherDTO {

    private Long familyId;
    private String firstName;
    private String secondName;
    private String pesel;
    private Date birthDate;

    public FatherDTO() {
    }

    public FatherDTO(Father i) {
        this.familyId = i.getFamilyId();
        this.firstName = i.getFirstName();
        this.secondName = i.getSecondName();
        this.pesel = i.getPesel();
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

    public Date getBirthDate() {
        return birthDate;
    }

    public FatherDTO(Long familyId, String firstName, String secondName, String pesel, Date birthDate) {
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }
}
