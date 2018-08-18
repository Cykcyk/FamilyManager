package app.controller;

import app.dao.father.Father;
import app.fatherDTO.FatherDTO;
import app.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familyManager/father")
public class FatherController {

    private final FatherService fatherService;

    @Autowired
    public FatherController(FatherService fatherService) {
        this.fatherService = fatherService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FatherDTO getFather(@PathVariable Long id) {
        Father father = fatherService.getFather(id);

        return new FatherDTO(father.getFamilyId(), father.getFirstName(),
                father.getSecondName(), father.getPesel(), father.getBirthDate());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Long addFatherToFamily(@RequestBody FatherDTO fatherDTO) {
        return fatherService.addFatherToFamily(fatherDTO);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<FatherDTO> getFatherListByFamilyIds(@RequestParam List<Long> familiesIds) {
        return fatherService.getFatherListByFamilyIds(familiesIds);
    }
}
