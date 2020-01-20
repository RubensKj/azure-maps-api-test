package br.com.hbsis.distance.services;

import br.com.hbsis.distance.payloads.*;
import org.springframework.stereotype.Service;

@Service
public class DistanceService {

    private final ApiIntegration apiIntegration;

    public DistanceService(ApiIntegration apiIntegration) {
        this.apiIntegration = apiIntegration;
    }

    public DistanceDTO getDistancesByCities(Addresses addresses) {
        return this.getDistanceBetweenAddresses(addresses);
    }

    private DistanceDTO getDistanceBetweenAddresses(Addresses addresses) {
        Result resultOrigin = this.searchByAddress(addresses.getOrigin());
        Result resultDestination = this.searchByAddress(addresses.getDestination());

        return this.getSummary(resultOrigin.getPosition(), resultDestination.getPosition());
    }

    private DistanceDTO getSummary(Position origin, Position destination) {
        ResponseRoute distanceBetweenAddress = apiIntegration.getDistanceBetweenAddress(origin, destination);
        Routes routes = distanceBetweenAddress.getRoutes().stream().findAny().orElseThrow(() -> new IllegalStateException("Não foi encontrado nenhuma rota."));
        return new DistanceDTO(routes.getSummary(), origin, destination);
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
