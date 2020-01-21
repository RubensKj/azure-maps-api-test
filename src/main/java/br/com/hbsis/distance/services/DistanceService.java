package br.com.hbsis.distance.services;

import br.com.hbsis.distance.payloads.AddressDTO;
import br.com.hbsis.distance.payloads.Addresses;
import br.com.hbsis.distance.payloads.DistanceAddresses;
import br.com.hbsis.distance.payloads.DistanceDTO;
import br.com.hbsis.distance.payloads.apiintegration.*;
import br.com.hbsis.distance.repositories.IAddressesRepository;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final ApiIntegration apiIntegration;

    private final IAddressesRepository iAddressesRepository;

    public DistanceService(ApiIntegration apiIntegration, IAddressesRepository iAddressesRepository) {
        this.apiIntegration = apiIntegration;
        this.iAddressesRepository = iAddressesRepository;
    }

    public DistanceDTO getDistancesByCities(Addresses addresses) {
        return this.getDistanceBetweenAddresses(addresses);
    }

    private DistanceDTO getDistanceBetweenAddresses(Addresses addresses) {
        if (this.validateIfDistanceHasAlreadyBeenCalculated(addresses)) {
            DistanceAddresses distanceAddresses = this.findByOriginAndDestination(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()));

            return new DistanceDTO(distanceAddresses.getDistance(), new Position(distanceAddresses.getLatOrigin(), distanceAddresses.getLonOrigin()), new Position(distanceAddresses.getLatDestination(), distanceAddresses.getLonDestination()));
        }
        Result resultOrigin = this.searchByAddress(addresses.getOrigin());
        Result resultDestination = this.searchByAddress(addresses.getDestination());

        return this.getSummary(resultOrigin.getPosition(), resultDestination.getPosition(), addresses);
    }

    private DistanceDTO getSummary(Position origin, Position destination, Addresses addresses) {
        ResponseRoute distanceBetweenAddress = apiIntegration.getDistanceBetweenAddress(origin, destination);
        Routes routes = distanceBetweenAddress.getRoutes().stream().findAny().orElseThrow(() -> new IllegalStateException("Não foi encontrado nenhuma rota."));
        this.iAddressesRepository.save(new DistanceAddresses(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()), routes.getSummary().getLengthInMeters(), origin.getLat(), origin.getLon(), destination.getLat(), destination.getLon()));
        return new DistanceDTO(routes.getSummary().getLengthInMeters(), origin, destination);
    }

    public DistanceAddresses findByOriginAndDestination(String origin, String destination) {
        System.out.println(origin + " asdjiasdj " + destination);
        return this.iAddressesRepository.findByOriginContainingAndDestinationContaining(origin.trim(), destination.trim()).orElseThrow(() -> new IllegalArgumentException("Endereços não encontrados"));
    }

    public boolean validateIfDistanceHasAlreadyBeenCalculated(Addresses addresses) {
        return this.iAddressesRepository.existsByOriginAndDestination(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()));
    }

    private Result searchByAddress(AddressDTO address) {
        ResponseSearch responseSearch = apiIntegration.searchAddressToGeolocation(address);
        return responseSearch.getResults().stream()
//                .filter(result -> result.getAddress().getStreetName().contains(address.getRua()))
//                .filter(result -> result.getAddress().getMunicipalitySubdivision().contains(address.getBairro()))
//                .filter(result -> result.getAddress().getMunicipality().contains(address.getCidade().toLowerCase()))
//                .filter(result -> result.getAddress().getCountrySubdivision().contains(address.getEstado()))
                .findAny().orElseThrow(() -> new IllegalStateException("Endereço não encontrado."));
    }
}
