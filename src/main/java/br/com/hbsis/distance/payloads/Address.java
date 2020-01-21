package br.com.hbsis.distance.payloads;

public class Address {

    private String streetName;
    private String municipalitySubdivision;
    private String municipality;
    private String countrySubdivision;
    private String postalCode;
    private String extendedPostalCode;
    private String country;
    private String freeformAddress;

    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public String getMunicipalitySubdivision() {
        return municipalitySubdivision;
    }

    public String getMunicipality() {
        return municipality;
    }

    public String getCountrySubdivision() {
        return countrySubdivision;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getExtendedPostalCode() {
        return extendedPostalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getFreeformAddress() {
        return freeformAddress;
    }
}
