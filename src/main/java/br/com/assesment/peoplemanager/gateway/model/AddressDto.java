package br.com.assesment.peoplemanager.gateway.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private long id;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String postCode;
    private String city;
    private String state;
}
