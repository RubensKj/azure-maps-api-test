package br.com.hbsis.distance.services;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

@Service
public class PropertiesValues {

    private static final String envFileName = "enviroment_config.env";

    public String getSubscriptionKey() {
        return this.getDotenv().get("subscription-key");
    }

    public String getUriAzureMapsInString() {
        return this.getDotenv().get("uri_azure_maps");
    }

    public URI getUriAzureMaps() throws URISyntaxException {
        return new URI(Objects.requireNonNull(this.getDotenv().get("uri_azure_maps")));
    }

    private Dotenv getDotenv() {
        return Dotenv.configure().directory("./").filename(envFileName).load();
    }
}
