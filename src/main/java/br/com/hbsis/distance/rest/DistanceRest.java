package br.com.hbsis.distance.rest;

import br.com.hbsis.distance.payloads.AddressTooLong;
import br.com.hbsis.distance.payloads.Addresses;
import br.com.hbsis.distance.payloads.DistanceAddresses;
import br.com.hbsis.distance.payloads.DistanceDTO;
import br.com.hbsis.distance.services.DistanceService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DistanceRest {

    private final DistanceService distanceService;

    public DistanceRest(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @PostMapping("/distance-between")
    public DistanceDTO getDistanceByCities(@Valid @RequestBody Addresses addresses) throws AddressTooLong {
        return this.distanceService.getDistancesByCities(addresses);
    }

    @GetMapping("/all-distances/{page}/{limit}")
    public Page<DistanceAddresses> getAll(@PathVariable int page, @PathVariable int limit) {
        return this.distanceService.findAll(PageRequest.of(page, limit));
    }
}
