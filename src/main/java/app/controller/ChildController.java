package app.controller;

import app.childDTO.ChildDTO;
import app.dao.child.Child;
import app.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/familyManager/child")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChildDTO getChild(@PathVariable Long id) {
        Child child = childService.getChild(id);

        return new ChildDTO(child.getFamilyId(), child.getFirstName(),
                child.getSecondName(), child.getPesel(), child.getGender(), child.getBirthDate());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Long addChildToFamily(@RequestBody ChildDTO childDTO) {
        return childService.addChildToFamily(childDTO);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<ChildDTO> searchChild(@RequestParam(value = "familyId", required = false) Long familyId,
                                      @RequestParam(value = "firstName", required = false) String firstName,
                                      @RequestParam(value = "secondName", required = false) String secondName,
                                      @RequestParam(value = "pesel", required = false) String pesel,
                                      @RequestParam(value = "birthDate", required = false) String birthDate,
                                      @RequestParam(value = "gender", required = false) String gender) {
        return childService.getListOfChildren(familyId, firstName, secondName, pesel, birthDate, gender);
    }
}
