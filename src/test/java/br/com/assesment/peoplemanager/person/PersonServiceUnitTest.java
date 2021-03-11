package br.com.assesment.peoplemanager.person;

import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.repository.PersonRepository;
import br.com.assesment.peoplemanager.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PersonServiceUnitTest {

    @Mock
    private final PersonServiceImpl personService = new PersonServiceImpl();
    @Mock
    private PersonRepository personRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insert_new_person_test() {
        Person person = Person.builder().build();
        when(personService.save(person)).thenReturn(person);
        assertEquals(0l, person);
    }

    @Test
    public void try_insert_person_with_duplicate_document() {
        Person person = Person.builder().build();
        when(personService.checkForDuplicateData(person)).thenReturn(true);
        assertEquals(0l, person);
    }
}
