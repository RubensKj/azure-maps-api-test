package br.com.hbsis.distance.payloads;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "addresses")
public class DistanceAddresses {

    @Id
    private String id;
    private String origin;
    private String destination;
    private int distance;
    private String latOrigin;
    private String lonOrigin;
    private String latDestination;
    private String lonDestination;


    public DistanceAddresses() {
    }

    public DistanceAddresses(String origin, String destination, int distance, String latOrigin, String lonOrigin, String latDestination, String lonDestination) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.latOrigin = latOrigin;
        this.lonOrigin = lonOrigin;
        this.latDestination = latDestination;
        this.lonDestination = lonDestination;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getLatOrigin() {
        return latOrigin;
    }

    public void setLatOrigin(String latOrigin) {
        this.latOrigin = latOrigin;
    }

    public String getLonOrigin() {
        return lonOrigin;
    }

    public void setLonOrigin(String lonOrigin) {
        this.lonOrigin = lonOrigin;
    }

    public String getLatDestination() {
        return latDestination;
    }

    public void setLatDestination(String latDestination) {
        this.latDestination = latDestination;
    }

    public String getLonDestination() {
        return lonDestination;
    }

    public void setLonDestination(String lonDestination) {
        this.lonDestination = lonDestination;
    }
}
