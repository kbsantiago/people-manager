package br.com.assesment.peoplemanager.person;

import br.com.assesment.peoplemanager.domain.Person;
import br.com.assesment.peoplemanager.gateway.model.PersonDto;
import br.com.assesment.peoplemanager.repository.PersonRepository;
import br.com.assesment.peoplemanager.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class PersonServiceUnitTest {

//    @Mock
//    private final PersonServiceImpl personService = new PersonServiceImpl();
//    @Mock
//    private PersonRepository personRepository;
//
//    @Before
//    public void init() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void try_insert_existent_proceed_test() {
//        long result = personService.save(new Person(1234, 10, "M", "SIM"));
//        assertEquals(0l, result);
//    }
//
//    @Test
//    public void insert_new_proceed_test() {
//        long result = 0l;
//        Person person = new Person(4444, 15, "F", "SIM");
//        when(personService.save(person)).thenReturn(result);
//        assertEquals(0l, result);
//    }
//
//    @Test
//    public void try_authorize_invalid_proceed_test() {
//        Person person = new Person();
//        when(personRepository.findByProceedAgeAndSex(5600, 10, "M")).thenReturn(procedimento);
//        assertEquals(String.valueOf(false), procedimento.isPermitido(), false);
//    }
//
//    @Test
//    public void try_authorize_valid_proceed_test() {
//        Procedimento procedimento = new Procedimento();
//        when(personRepository.findByProceedAgeAndSex(1234, 10, "M")).thenReturn(procedimento);
//        assertEquals(String.valueOf(true), procedimento.isPermitido(), false);
//    }

}
