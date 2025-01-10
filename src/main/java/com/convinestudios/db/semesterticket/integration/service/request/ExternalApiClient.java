package com.convinestudios.db.semesterticket.integration.service.request;

import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;
import reactor.netty.resources.ConnectionProvider;

import java.time.Duration;
import java.util.Map;

public class ExternalApiClient {

    private final WebClient webClient;

    public ExternalApiClient(String apiUrl, Map<String, String> headers, int maxInMemorySize, int maxConnections) {

        ConnectionProvider connectionProvider = ConnectionProvider.builder("custom")
                .maxConnections(maxConnections)
                .pendingAcquireTimeout(Duration.ofSeconds(30))
                .maxIdleTime(Duration.ofSeconds(20))
                .build();

        HttpClient httpClient = HttpClient.create(connectionProvider)
                .responseTimeout(Duration.ofSeconds(10))
                .doOnConnected(conn -> conn
                        .addHandlerLast(new ReadTimeoutHandler(10))
                        .addHandlerLast(new WriteTimeoutHandler(10)));

        this.webClient = WebClient.builder()
                .baseUrl(apiUrl)
                .defaultHeaders(httpHeaders -> headers.forEach(httpHeaders::add))
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(maxInMemorySize))
                .build();
    }

    public Mono<String> post(String body) {
        return webClient.post()
                .bodyValue(body)
                .retrieve()
                .bodyToMono(String.class)
                .retryWhen(reactor.util.retry.Retry.backoff(3, Duration.ofSeconds(2)))
                .onErrorResume(e -> Mono.error(new RuntimeException("Failed to post request", e)));
    }

    public Flux<String> post(Flux<String> bodies) {
        return bodies.flatMap(this::post,5);
    }
}
