package com.jobhunter.simpleBackEnd;

import com.jobhunter.simpleBackEnd.models.PotentialEmployees;
import com.jobhunter.simpleBackEnd.repositories.PotentialEmployeesRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/potential_employees")
public class PotentialEmployeesController {
    private final PotentialEmployeesRepository repository;

    public PotentialEmployeesController(PotentialEmployeesRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<PotentialEmployees> getPotentialEmployees(@RequestParam(required = false) Integer page,
                                                             @RequestParam(required = false) String sortDirection,
                                                             @RequestParam(required = false) String contains) {

        PageRequest pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "createDate");

        if(page != null && sortDirection != null) {
            switch (sortDirection) {
                case "A-Z": {
                    pageRequest = PageRequest.of(page, 10, Sort.Direction.ASC, "vacancyRequired");
                    break;
                }
                case "Z-A": {
                    pageRequest = PageRequest.of(page, 10, Sort.Direction.DESC, "vacancyRequired");
                    break;
                }
                case "newFirst": {
                    pageRequest = PageRequest.of(page, 10, Sort.Direction.DESC, "createDate");
                    break;
                }
                case "oldFirst": {
                    pageRequest = PageRequest.of(page, 10, Sort.Direction.ASC, "createDate");
                    break;
                }
            }
        }
        else if(page != null)
            pageRequest = PageRequest.of(page, 10, Sort.Direction.DESC, "createDate");

        if(contains != null)
            return repository.findAll(pageRequest)
                    .getContent()
                    .stream()
                    .filter(x -> x.getVacancyRequired().toLowerCase().contains(contains.toLowerCase()) || x.getAboutYourself().toLowerCase().contains(contains.toLowerCase()))
                    .collect(Collectors.toList());

        return repository.findAll(pageRequest).getContent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PotentialEmployees getPotentialEmployeeById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public PotentialEmployees modifyPotentialEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody PotentialEmployees potentialEmployees) {
        potentialEmployees.set_id(id);
        potentialEmployees.setCreateDate(new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss").format(new Date()));
        repository.save(potentialEmployees);
        return potentialEmployees;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public PotentialEmployees createPotentialEmployee(@Valid @RequestBody PotentialEmployees potentialEmployees) {
        potentialEmployees.set_id(ObjectId.get());
        potentialEmployees.setCreateDate(new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss").format(new Date()));
        repository.save(potentialEmployees);
        return potentialEmployees;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletePotentialEmployee(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
        return "Deleted!";
    }
}
