package br.com.assesment.peoplemanager.service;

import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.repository.PersonRepository;
import br.com.assesment.peoplemanager.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.exact;

public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean isValid(Person person) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("document", exact());
        Example<Person> example = Example.of(person, matcher);
        return personRepository.exists(example);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person getById(Long id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "nome");
        List<Person> people = personRepository.findAll(pageable).getContent();
        return people;
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
