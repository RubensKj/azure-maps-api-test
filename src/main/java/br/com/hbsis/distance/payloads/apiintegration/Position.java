package br.com.hbsis.distance.payloads.apiintegration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Position {

    private String lat;
    private String lon;

}
