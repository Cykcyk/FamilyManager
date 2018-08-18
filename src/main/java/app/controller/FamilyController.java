package app.controller;


import app.dao.family.Family;
import app.familyDTO.FamilyDTO;
import app.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familyManager/family")
public class FamilyController {

    private final
    FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FamilyDTO getFamily(@PathVariable Long id) {
        Family family = familyService.getFamily(id);

        return new FamilyDTO(family.getId(), family.getCreationDate());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Long createFamily(@RequestBody FamilyDTO familyDTO) {
        return familyService.createFamily(familyDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<FamilyDTO> getFamilies(@RequestParam(value = "childFirstName", required = false) String childFirstName,
                                        @RequestParam(value = "childLastName", required = false) String childLastName,
                                        @RequestParam(value = "childPesel", required = false) String childPesel,
                                        @RequestParam(value = "childBirthDate", required = false) Date childBirthDate,
                                        @RequestParam(value = "childGender", required = false) String childGender) {
        return familyService.getListOfFamilies(childFirstName, childLastName, childPesel, childBirthDate, childGender);
    }

}
