package app.service;

import app.childDTO.ChildDTO;
import app.dao.child.Child;
import app.dao.child.ChildDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ChildService {

    private final
    ChildDao childDao;

    @Autowired
    public ChildService(ChildDao childDao) {
        this.childDao = childDao;
    }

    public Long addChildToFamily(ChildDTO childDTO) {
        Child child = new Child(childDTO.getFamilyId(), childDTO.getFirstName(), childDTO.getSecondName(), childDTO.getPesel(), childDTO.getGender(), childDTO.getBirthDate());

        return childDao.addChildToFamily(child);
    }

    public Child getChild(Long id) {
        return childDao.getChild(id);
    }

    public List<ChildDTO> getListOfChildren(Long familyId, String firstName, String secondName, String pesel, String birthDate, String gender) {
        List<Child> children;
        children = childDao.getChildrenList(familyId, firstName, secondName, pesel, birthDate, gender);
        List<ChildDTO> childrenDTOList = new ArrayList<>();
        for (Child i : children) {
            childrenDTOList.add(new ChildDTO(i));
        }
        return childrenDTOList;
    }
}
