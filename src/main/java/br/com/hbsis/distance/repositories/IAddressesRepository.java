package br.com.hbsis.distance.repositories;

import br.com.hbsis.distance.payloads.DistanceAddresses;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAddressesRepository extends MongoRepository<DistanceAddresses, String> {

    boolean existsByOriginAndDestination(String origin, String destination);

    Optional<DistanceAddresses> findByOriginContainingAndDestinationContaining(String origin, String destination);
}
