package br.com.hbsis.distance.payloads.apiintegration;

import br.com.hbsis.distance.payloads.Address;

public class Result {

    private Address address;
    private Position position;

    public Result() {
    }

    public Address getAddress() {
        return address;
    }

    public Position getPosition() {
        return position;
    }
}
