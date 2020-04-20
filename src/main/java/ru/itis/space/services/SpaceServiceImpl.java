package ru.itis.space.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import ru.itis.space.clients.SpaceClient;
import ru.itis.space.entires.SpaceStatistics;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private List<SpaceClient> clients;

    @Override
    public Flux<SpaceStatistics> getAll() {
        List<Flux<SpaceStatistics>> fluxes =  clients.stream().map(this::getAll).collect(Collectors.toList());
        return Flux.merge(fluxes);
    }

    private Flux<SpaceStatistics> getAll(SpaceClient client){
        return client.getAll().subscribeOn(Schedulers.elastic());
    }
}
