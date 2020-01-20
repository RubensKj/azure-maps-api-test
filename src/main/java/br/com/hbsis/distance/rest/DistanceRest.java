package br.com.hbsis.distance.rest;

import br.com.hbsis.distance.payloads.Addresses;
import br.com.hbsis.distance.payloads.DistanceDTO;
import br.com.hbsis.distance.services.DistanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class DistanceRest {

    private final DistanceService distanceService;

    public DistanceRest(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/distance-between")
    public DistanceDTO getDistanceByCities(@Valid @RequestBody Addresses addresses) {
        return this.distanceService.getDistancesByCities(addresses);
    }
}
