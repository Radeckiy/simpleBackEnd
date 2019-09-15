package com.jobhunter.simpleBackEnd;

import com.jobhunter.simpleBackEnd.models.Employers;
import com.jobhunter.simpleBackEnd.repositories.EmployersRepository;
import org.bson.types.ObjectId;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employers")
public class EmployersController {
    private final EmployersRepository repository;

    public EmployersController(EmployersRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Employers> getEmployers(@RequestParam(required = false) Integer page,
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
                    .filter(x -> x.getVacancyRequired().toLowerCase().contains(contains.toLowerCase()) || x.getVacancyDescription().toLowerCase().contains(contains.toLowerCase()))
                    .collect(Collectors.toList());

        return repository.findAll(pageRequest).getContent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employers getEmployerById(@PathVariable("id") ObjectId id) {
        return repository.findBy_id(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Employers modifyEmployerById(@PathVariable("id") ObjectId id, @Valid @RequestBody Employers employers) {
        employers.set_id(id);
        employers.setCreateDate(new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss").format(new Date()));
        repository.save(employers);
        return employers;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Employers createEmployer(@Valid @RequestBody Employers employers) {
        employers.set_id(ObjectId.get());
        employers.setCreateDate(new SimpleDateFormat("dd.MM.yyyy 'at' HH:mm:ss").format(new Date()));
        repository.save(employers);
        return employers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteEmployer(@PathVariable ObjectId id) {
        repository.delete(repository.findBy_id(id));
        return "Deleted!";
    }
}

