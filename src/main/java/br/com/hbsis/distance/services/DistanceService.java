package br.com.hbsis.distance.services;

import br.com.hbsis.distance.payloads.AddressDTO;
import br.com.hbsis.distance.payloads.Addresses;
import br.com.hbsis.distance.payloads.DistanceAddresses;
import br.com.hbsis.distance.payloads.DistanceDTO;
import br.com.hbsis.distance.payloads.apiintegration.*;
import br.com.hbsis.distance.repositories.IAddressesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static br.com.hbsis.distance.utils.ValidationUtils.validadeIfEmpty;
import static br.com.hbsis.distance.utils.ValidationUtils.validateIfNull;

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

    private void validate(Addresses addresses) {
        validateIfNull(addresses.getOrigin().getBairro(), "bairro da origem não pode ser nulo");
        validateIfNull(addresses.getOrigin().getCidade(), "cidade da origem não pode ser nula");
        validateIfNull(addresses.getOrigin().getEstado(), "estado (UF) da origem não pode ser nulo");
        validateIfNull(addresses.getDestination().getBairro(), "bairro do destino não pode ser nulo");
        validateIfNull(addresses.getDestination().getCidade(), "cidade do destino não pode ser nula");
        validateIfNull(addresses.getDestination().getEstado(), "estado do destino não pode ser nulo");

        validadeIfEmpty(addresses.getOrigin().getBairro(), "bairro da origem não pode ser vazio");
        validadeIfEmpty(addresses.getOrigin().getCidade(), "cidade do destino não pode ser vazia");
        validadeIfEmpty(addresses.getDestination().getCidade(), "cidade do destino não pode ser vazia");
        validadeIfEmpty(addresses.getDestination().getBairro(), "bairro do destino não pode ser vazio");
    }

    private DistanceDTO getDistanceBetweenAddresses(Addresses addresses) {
        this.validate(addresses);
        if (this.validateIfDistanceHasAlreadyBeenCalculated(addresses)) {
            DistanceAddresses distanceAddresses = this.findByOriginAndDestination(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()));

            return new DistanceDTO(distanceAddresses.getDistanceInMeters(), distanceAddresses.getOriginPosition(), distanceAddresses.getDestinationPosition());
        }
        Result resultOrigin = this.searchByAddress(addresses.getOrigin());
        Result resultDestination = this.searchByAddress(addresses.getDestination());

        return this.getSummary(resultOrigin.getPosition(), resultDestination.getPosition(), addresses);
    }

    private DistanceDTO getSummary(Position origin, Position destination, Addresses addresses) {
        ResponseRoute distanceBetweenAddress = apiIntegration.getDistanceBetweenAddress(origin, destination);
        Routes routes = distanceBetweenAddress.getRoutes().stream().findAny().orElseThrow(() -> new IllegalStateException("Não foi encontrado nenhuma rota."));

        new Thread(() -> this.iAddressesRepository.save(new DistanceAddresses(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()).trim(), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()).trim(), routes.getSummary().getLengthInMeters(), origin, destination))).start();

        return new DistanceDTO(routes.getSummary().getLengthInMeters(), origin, destination);
    }

    private DistanceAddresses findByOriginAndDestination(String origin, String destination) {
        return this.iAddressesRepository.findByOriginContainingAndDestinationContaining(origin.trim(), destination.trim()).orElseThrow(() -> new IllegalArgumentException("Endereços não encontrados"));
    }

    private boolean validateIfDistanceHasAlreadyBeenCalculated(Addresses addresses) {
        return this.iAddressesRepository.existsByOriginAndDestination(this.apiIntegration.getAddressInStringByDTO(addresses.getOrigin()), this.apiIntegration.getAddressInStringByDTO(addresses.getDestination()));
    }

    private Result searchByAddress(AddressDTO address) {
        ResponseSearch responseSearch = apiIntegration.searchAddressToGeolocation(address);
        return responseSearch.getResults().stream().findAny().orElseThrow(() -> new IllegalStateException("Endereço não encontrado."));
    }

    public Page<DistanceAddresses> findAll(Pageable pageable) {
        return this.iAddressesRepository.findAll(pageable);
    }
}
