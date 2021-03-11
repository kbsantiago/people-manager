package br.com.assesment.peoplemanager.gateway.http;

import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.gateway.model.PersonDto;
import br.com.assesment.peoplemanager.service.PersonServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path="/api/v1/person")
@ResponseBody
@CrossOrigin("*")
@Api(value="Person")
@AllArgsConstructor
public class PersonController {

    @Autowired
    private final PersonServiceImpl personService;
    @Autowired
    private final ModelMapper modelMapper;

    @ApiOperation(value = "Return a pageable list of people", authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PersonDto>> getAllPersonPageable(@RequestParam int page, @RequestParam int size) {
        List<PersonDto> people = personService.getAllPaginated(page, size)
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(people);
    }

    @ApiOperation(value = "Return single person by id", authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable String id) {
        Person person = personService.getById(Long.parseLong(id));
        if(person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(person, PersonDto.class));
    }

    @ApiOperation(value = "Add and return person", authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<PersonDto> save(@RequestBody PersonDto personDto) {
        final Person person;
        boolean exists = personService.checkForDuplicateData(modelMapper.map(personDto, Person.class));
        if(!exists)
            person = personService.save(modelMapper.map(personDto, Person.class));
        else
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(person, PersonDto.class));
    }

    @ApiOperation(value = "Update and return person", authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        Person person = personService.getById(personDto.getId());
        if(person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            boolean exists = personService.checkForDuplicateData(modelMapper.map(personDto, Person.class));
            if(!exists) {
                person = personService.save(modelMapper.map(personDto, Person.class));
                return ResponseEntity.status(HttpStatus.OK).body(modelMapper.map(person, PersonDto.class));
            } else {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
            }
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @ApiOperation(value = "Delete person by id", authorizations = { @Authorization(value="jwtToken") })
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        Person person = personService.getById(id);
        if(person == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        try {
            personService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    private PersonDto convertToDto(Person person) {
        PersonDto personDto = modelMapper.map(person, PersonDto.class);
        return personDto;
    }

}