package app.service;

import app.dao.family.Family;
import app.dao.family.FamilyDao;
import app.familyDTO.FamilyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Component
public class FamilyService {

    private final
    FamilyDao familyDao;

    @Autowired
    public FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    public Family getFamily(Long id) {

        return familyDao.getFamily(id);
    }

    public Long createFamily(FamilyDTO familyDTO) {

        Family family = new Family(familyDTO.getId(), familyDTO.getCreationDate());

        return familyDao.createFamily(family);
    }

    public List<FamilyDTO> getListOfFamilies(String childFirstName, String childLastName, String childPesel, Date childBirthDate, String childSex) {
        List<Family> familyList;
        familyList = familyDao.getFamilyList(childFirstName, childLastName, childPesel, childBirthDate, childSex);
        List<FamilyDTO> familyDTOList = new ArrayList<>();
        assert familyList != null;
        for (Family i : familyList) {
            familyDTOList.add(new FamilyDTO(i));
        }
        return familyDTOList;
    }
}
