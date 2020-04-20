package ru.itis.space.clients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ru.itis.space.entires.AstrosApiRecord;
import ru.itis.space.entires.AstrosApiResponse;
import ru.itis.space.entires.SpaceStatistics;

import java.util.Arrays;

@Component
public class AstrosApiClientImpl implements SpaceClient {

    private WebClient client;

    public AstrosApiClientImpl(@Value("${space.api.url}") String url) {
        client = WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(clientCodecConfigurer -> clientCodecConfigurer.defaultCodecs().maxInMemorySize(100 * 1024 * 1024))
                        .build())
                .baseUrl(url)
                .build();
    }

    @Override
    public Flux<SpaceStatistics> getAll() {
        return client.get()
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(AstrosApiResponse.class))
                .flatMapIterable(AstrosApiResponse::getPeople)
                .map(record ->
                        SpaceStatistics.builder()
                                .name(record.getName())
                                .spacrShip(record.getCraft())
                                .from("AstrosApi")
                                .build());
    }
}
