package br.com.hbsis.distance.payloads;

import br.com.hbsis.distance.payloads.apiintegration.Position;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Getter
@Setter
@Document(collection = "addresses")
public class DistanceAddresses {

    @Id
    private String id;
    private String origin;
    private String destination;
    private int distanceInMeters;
    private Position originPosition;
    private Position destinationPosition;


    public DistanceAddresses(String origin, String destination, int distanceInMeters, Position originPosition, Position destinationPosition) {
        this.origin = origin;
        this.destination = destination;
        this.distanceInMeters = distanceInMeters;
        this.originPosition = originPosition;
        this.destinationPosition = destinationPosition;
    }
}
