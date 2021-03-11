package br.com.assesment.peoplemanager.repository;

import br.com.assesment.peoplemanager.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

@Transactional
public interface PersonRepository extends JpaRepository<Person, Long> {
    boolean findByDocument(String document);
}
