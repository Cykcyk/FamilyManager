package app.dao.father;

import java.util.Date;

public class Father {

    private Long fatherId;
    private Long familyId;
    private String firstName;
    private String secondName;
    private String pesel;
    private Date birthDate;


    Father() {
    }

    public Father(Long familyId, String firstName, String secondName, String pesel, Date birthDate) {
        this.familyId = familyId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }

    public Long getFamilyId() {
        return familyId;
    }

    void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    Long getFatherId() {
        return fatherId;
    }

    void setFatherId(Long fatherId) {
        this.fatherId = fatherId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
