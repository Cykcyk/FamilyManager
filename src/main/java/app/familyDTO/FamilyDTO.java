package app.familyDTO;

import app.dao.family.Family;

import java.sql.Date;

public class FamilyDTO {

    private Long id;
    private Date creationDate;

    public FamilyDTO(Long id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    public FamilyDTO(Family i) {
        this.id = i.getId();
        this.creationDate = i.getCreationDate();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public FamilyDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
