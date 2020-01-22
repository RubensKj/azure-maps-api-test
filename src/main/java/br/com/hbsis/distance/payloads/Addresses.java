package br.com.hbsis.distance.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class Addresses {

    private AddressDTO origin;
    private AddressDTO destination;

}
