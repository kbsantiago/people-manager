package br.com.assesment.peoplemanager.service.interfaces;

import br.com.assesment.peoplemanager.domain.Person;

import java.util.List;

public interface PersonService {
    boolean checkForDuplicateData(Person person);
    Person save(Person person);
    Person getById(Long id);
    List<Person> getAllPaginated(int page, int size);
    void delete(long id);
}
