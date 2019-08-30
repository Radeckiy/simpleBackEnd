package com.jobhunter.simpleBackEnd;

import com.jobhunter.simpleBackEnd.models.Employers;
import com.jobhunter.simpleBackEnd.repositories.EmployersRepository;
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
@RequestMapping("/employers")
public class EmployersController {
    @Autowired
    private EmployersRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employers> getAllEmployers() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employers getEmployerById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modifyEmployerById(@PathVariable("id") ObjectId id, @Valid @RequestBody Employers employers) {
        employers.set_id(id);
        repository.save(employers);
        return "Updated!";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employers createEmployer(@Valid @RequestBody Employers employers) {
        employers.set_id(ObjectId.get());
        repository.save(employers);
        return employers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEmployer(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
        return "Deleted!";
    }
}

