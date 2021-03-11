package br.com.assesment.peoplemanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "person")
public class Person {
    @Id @GeneratedValue
    private long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String birthPlace;
    private String nationality;
    private String document;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn( name = "address_id" )
    @JsonManagedReference
    private Address address;
}
