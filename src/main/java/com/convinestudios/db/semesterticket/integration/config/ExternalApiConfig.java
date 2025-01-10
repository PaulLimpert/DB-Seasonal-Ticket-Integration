package com.convinestudios.db.semesterticket.integration.config;

import com.convinestudios.db.semesterticket.integration.service.request.ExternalApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ExternalApiConfig {

    // todo: configure beans for ExternalApiService and ExternalApiClient

    @Bean
    public ExternalApiClient defaultClientDB() {
        return new ExternalApiClient(
                "https://www.bahn.de/web/api/angebote/fahrplan",
                Map.of("Content-Type", "application/json"),
                2 * 1024 * 1024,
                50
        );
    }
}
