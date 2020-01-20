package br.com.hbsis.distance.services;

import br.com.hbsis.distance.payloads.AddressDTO;
import br.com.hbsis.distance.payloads.Position;
import br.com.hbsis.distance.payloads.ResponseRoute;
import br.com.hbsis.distance.payloads.ResponseSearch;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ApiIntegration {

    private final PropertiesValues propertiesValues;

    public ApiIntegration(PropertiesValues propertiesValues) {
        this.propertiesValues = propertiesValues;
    }

    public ResponseSearch searchAddressToGeolocation(AddressDTO address) {
        RestTemplate restTemplate = HttpUtil.getRestTemplate();
        UriComponents build = UriComponentsBuilder.fromUriString(this.getUrlToSearchInAzure())
                .queryParam("subscription-key", this.propertiesValues.getSubscriptionKey())
                .queryParam("query", this.getAddressInStringByDTO(address))
                .queryParam("countrySet", "BR")
                .queryParam("maxFuzzyLevel", 2)
                .queryParam("limit", 1)
                .queryParam("api-version", "1.0")
                .query("").build();
        ResponseEntity<ResponseSearch> exchange = restTemplate.getForEntity(build.toUriString(), ResponseSearch.class);
        return exchange.getBody();
    }

    private String getUrlToSearchInAzure() {
        return this.propertiesValues.getUriAzureMapsInString().concat("/search/address/json");
    }

    private String getAddressInStringByDTO(AddressDTO addressDTO) {
        if (addressDTO.getBairro().contains("Bairro")) {
            addressDTO.setBairro(addressDTO.getBairro().replace("Bairro ", ""));
        }

        if (!StringUtils.isEmpty(addressDTO.getRua())) {
            return addressDTO.getRua() + ", " + addressDTO.getBairro() + ", " + addressDTO.getCidade() + " - " + addressDTO.getEstado();
        } else {
            return addressDTO.getBairro() + ", " + addressDTO.getCidade() + " - " + addressDTO.getEstado();
        }
    }

    public ResponseRoute getDistanceBetweenAddress(Position positionOrigin, Position positionDestination) {
        RestTemplate restTemplate = HttpUtil.getRestTemplate();
        UriComponents uriFromString = UriComponentsBuilder.fromUriString(this.getUrlToDirectionsInAzure())
                .queryParam("subscription-key", this.propertiesValues.getSubscriptionKey())
                .queryParam("query", this.returnQueryToRoute(positionOrigin, positionDestination))
                .queryParam("vehicleCommercial", true)
                .queryParam("traffic", true)
                .queryParam("routeType", "eco")
                .queryParam("api-version", "1.0").build();
        ResponseEntity<ResponseRoute> exchange = restTemplate.getForEntity(uriFromString.toUriString(), ResponseRoute.class);
        return exchange.getBody();
    }

    private String getUrlToDirectionsInAzure() {
        return this.propertiesValues.getUriAzureMapsInString().concat("/route/directions/json");
    }

    private String returnQueryToRoute(Position positionOrigin, Position positionDestination) {
        return positionOrigin.getLat() + "," + positionOrigin.getLon()
                + ":" + positionDestination.getLat() + "," + positionDestination.getLon();
    }
}
