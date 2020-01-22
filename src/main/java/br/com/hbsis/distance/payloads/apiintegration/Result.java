package br.com.hbsis.distance.payloads.apiintegration;

import br.com.hbsis.distance.payloads.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class Result {

    private Address address;
    private Position position;

}
