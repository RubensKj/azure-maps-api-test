package br.com.hbsis.distance.payloads;

import br.com.hbsis.distance.payloads.apiintegration.Position;

public class DistanceDTO {

    private long distanceInMeters;
    private Position origin;
    private Position destination;

    public DistanceDTO() {
    }

    public DistanceDTO(long distanceInMeters, Position origin, Position destination) {
        this.distanceInMeters = distanceInMeters;
        this.origin = origin;
        this.destination = destination;
    }

    public DistanceDTO(long distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public long getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(long distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public Position getOrigin() {
        return origin;
    }

    public Position getDestination() {
        return destination;
    }
}
