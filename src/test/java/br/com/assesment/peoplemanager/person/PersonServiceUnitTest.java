package br.com.assesment.peoplemanager.person;

import br.com.assesment.peoplemanager.domain.Address;
import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.repository.PersonRepository;
import br.com.assesment.peoplemanager.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
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
        Address address = Address.builder()
                .addressLine1("Addres line 1")
                .addressLine2("Address line 2")
                .addressLine3("Address line 3")
                .city("Florianópolis")
                .state("Santa Catarina")
                .postCode("89000000")
                .build();
        Person person = Person.builder()
                .name("John Doe")
                .email("johndoe@gmail.com")
                .birthPlace("Florianópolis")
                .birthDate(LocalDate.of(1988, 01, 14))
                .document("92018068223")
                .address(address).build();
        when(personService.save(person)).thenReturn(person);
        assertEquals(0l, person.getId());
    }

    @Test
    public void try_insert_person_with_duplicate_document() {
        Person person = Person.builder().build();
        when(personService.checkForDuplicateData(person)).thenReturn(true);
        assertEquals(0l, person);
    }
}
