package app.service;

import app.dao.father.Father;
import app.dao.father.FatherDao;
import app.fatherDTO.FatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FatherService {

    private final
    FatherDao fatherDao;

    @Autowired
    public FatherService(FatherDao fatherDao) {
        this.fatherDao = fatherDao;
    }

    public Long addFatherToFamily(FatherDTO fatherDTO) {
        Father father = new Father(fatherDTO.getFamilyId(), fatherDTO.getFirstName(), fatherDTO.getSecondName(), fatherDTO.getPesel(), fatherDTO.getBirthDate());

        return fatherDao.addFatherToFamily(father);
    }

    public Father getFather(Long id) {
        return fatherDao.getFather(id);
    }

    public List<FatherDTO> getFatherListByFamilyIds(List<Long> familiesIds) {
        List<Father> fatherList = new ArrayList<>();
        for (Long familiesId : familiesIds) {
            fatherList.add(fatherDao.getFatherByFamilyId(familiesId));
        }
        List<FatherDTO> fatherDTOList = new ArrayList<>();
        for (Father i : fatherList) {
            fatherDTOList.add(new FatherDTO(i));
        }
        return fatherDTOList;
    }
}
