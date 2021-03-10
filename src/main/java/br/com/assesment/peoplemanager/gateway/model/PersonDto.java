package br.com.assesment.peoplemanager.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private String birthPlace;
    private String nationality;
    private String document;
    private AddressDto addressDto;
}