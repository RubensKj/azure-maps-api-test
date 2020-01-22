package br.com.hbsis.distance.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Address {

    private String streetName;
    private String municipalitySubdivision;
    private String municipality;
    private String countrySubdivision;
    private String postalCode;
    private String extendedPostalCode;
    private String country;
    private String freeformAddress;
}
