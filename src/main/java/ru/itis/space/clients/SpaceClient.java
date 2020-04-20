package ru.itis.space.clients;

import reactor.core.publisher.Flux;
import ru.itis.space.entires.SpaceStatistics;

public interface SpaceClient {
    Flux<SpaceStatistics> getAll();
}
