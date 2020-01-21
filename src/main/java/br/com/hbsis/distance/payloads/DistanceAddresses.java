package br.com.hbsis.distance.payloads;

import br.com.hbsis.distance.payloads.apiintegration.Position;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class DistanceAddresses {

    @Id
    private String id;
    private String origin;
    private String destination;
    private int distanceInMeters;
    private Position originPosition;
    private Position destinationPosition;


    public DistanceAddresses() {
    }

    public DistanceAddresses(String origin, String destination, int distanceInMeters, Position originPosition, Position destinationPosition) {
        this.origin = origin;
        this.destination = destination;
        this.distanceInMeters = distanceInMeters;
        this.originPosition = originPosition;
        this.destinationPosition = destinationPosition;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

    public void setDistanceInMeters(int distanceInMeters) {
        this.distanceInMeters = distanceInMeters;
    }

    public Position getOriginPosition() {
        return originPosition;
    }

    public void setOriginPosition(Position originPosition) {
        this.originPosition = originPosition;
    }

    public Position getDestinationPosition() {
        return destinationPosition;
    }

    public void setDestinationPosition(Position destinationPosition) {
        this.destinationPosition = destinationPosition;
    }
}
