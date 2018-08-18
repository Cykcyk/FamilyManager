package app.dao.family;

import java.sql.Date;

public class Family {
    
    private Long id;
    private Date creationDate;

    public Family(Long id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
    }

    Family() {

    }

    public Date getCreationDate() {
        return creationDate;
    }

    void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
