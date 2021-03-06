package br.com.assesment.peoplemanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "address")
public class Address {
    @Id @GeneratedValue
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postCode;
    private String city;
    private String state;
}
