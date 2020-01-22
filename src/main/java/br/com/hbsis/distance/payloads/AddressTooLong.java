package br.com.hbsis.distance.payloads;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
public class AddressTooLong extends Exception {
    public AddressTooLong(String message) {
        super(message);
    }
}
