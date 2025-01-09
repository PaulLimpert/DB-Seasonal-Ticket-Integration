package com.convinestudios.db.semesterticket.integration.service.request;

import com.convinestudios.db.semesterticket.integration.model.external.HeaderModel;
import com.convinestudios.db.semesterticket.integration.model.external.payload.Payload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class ExternalApiClient {

    private final WebClient webClient;

    @Autowired
    public ExternalApiClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://www.bahn.de/web/api/angebote/fahrplan").build();
    }

    public Mono<String> postResponse(String uri, List<HeaderModel> headers, Payload payload) {
        WebClient.RequestBodySpec request = webClient.post().uri(uri);

        for (HeaderModel header: headers){
            request.header(header.getName(), header.getValue());
        }

        return request.bodyValue(payload)
                .retrieve()
                .bodyToMono(String.class);
    }
}
