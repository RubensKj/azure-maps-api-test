package br.com.hbsis.distance.payloads;

public class Summary {

    private int lengthInMeters;
    private int travelTimeInSeconds;
    private int trafficDelayInSeconds;
    private String departureTime;
    private String arrivalTime;

    public Summary() {
    }

    public int getLengthInMeters() {
        return lengthInMeters;
    }

    public int getTravelTimeInSeconds() {
        return travelTimeInSeconds;
    }

    public int getTrafficDelayInSeconds() {
        return trafficDelayInSeconds;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }
}
