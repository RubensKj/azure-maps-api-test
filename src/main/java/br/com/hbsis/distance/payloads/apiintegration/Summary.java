package br.com.hbsis.distance.payloads.apiintegration;


import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Summary {

    private int lengthInMeters;
    private int travelTimeInSeconds;
    private int trafficDelayInSeconds;
    private String departureTime;
    private String arrivalTime;

}
