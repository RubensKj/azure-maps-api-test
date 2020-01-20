package br.com.hbsis.distance.payloads;

public class Addresses {

    private AddressDTO origin;
    private AddressDTO destination;

    public Addresses() {
    }

    public Addresses(AddressDTO origin, AddressDTO destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public AddressDTO getOrigin() {
        return origin;
    }

    public AddressDTO getDestination() {
        return destination;
    }
}
