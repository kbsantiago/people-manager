package br.com.assesment.peoplemanager.service;

import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.repository.PersonRepository;
import br.com.assesment.peoplemanager.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public boolean checkForDuplicateData(Person person) {
        return personRepository.findByDocument(person.getDocument());
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
    public List<Person> getAllPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "name");
        List<Person> people = personRepository.findAll(pageable).getContent();
        return people;
    }

    @Override
    public void delete(long id) {
        personRepository.deleteById(id);
    }
}
