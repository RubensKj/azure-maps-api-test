package br.com.hbsis.distance.payloads;

import br.com.hbsis.distance.payloads.apiintegration.Position;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DistanceDTO {

    private long distanceInMeters;
    private Position origin;
    private Position destination;
}
