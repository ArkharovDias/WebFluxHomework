package ru.itis.space.services;


import reactor.core.publisher.Flux;
import ru.itis.space.entires.SpaceStatistics;

public interface SpaceService {
    Flux<SpaceStatistics> getAll();
}
