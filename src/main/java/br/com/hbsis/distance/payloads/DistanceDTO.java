package br.com.hbsis.distance.payloads;

import br.com.hbsis.distance.payloads.apiintegration.Position;
import br.com.hbsis.distance.payloads.apiintegration.Summary;

public class DistanceDTO {

    private Summary summary;
    private Position origin;
    private Position destination;

    public DistanceDTO() {
    }

    public DistanceDTO(Summary summary, Position origin, Position destination) {
        this.summary = summary;
        this.origin = origin;
        this.destination = destination;
    }

    public Summary getSummary() {
        return summary;
    }

    public Position getOrigin() {
        return origin;
    }

    public Position getDestination() {
        return destination;
    }
}
