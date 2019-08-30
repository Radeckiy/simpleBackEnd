package com.jobhunter.simpleBackEnd;

import com.jobhunter.simpleBackEnd.models.PotentialEmployees;
import com.jobhunter.simpleBackEnd.repositories.PotentialEmployeesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/potential_employees")
public class PotentialEmployeesController {
    @Autowired
    private PotentialEmployeesRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PotentialEmployees> getAllPotentialEmployees() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PotentialEmployees getPotentialEmployeeById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modifyPotentialEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody PotentialEmployees potentialEmployees) {
        potentialEmployees.set_id(id);
        repository.save(potentialEmployees);
        return "Updated!";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PotentialEmployees createPotentialEmployee(@Valid @RequestBody PotentialEmployees potentialEmployees) {
        potentialEmployees.set_id(ObjectId.get());
        repository.save(potentialEmployees);
        return potentialEmployees;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePotentialEmployee(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
        return "Deleted!";
    }
}
