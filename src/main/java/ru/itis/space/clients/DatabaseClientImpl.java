package ru.itis.space.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import ru.itis.space.entires.SpaceStatistics;
import ru.itis.space.entires.models.DatabaseRecord;
import ru.itis.space.repositories.CosmonautRepository;

import java.util.List;

@Component
public class DatabaseClientImpl implements SpaceClient{

    @Autowired
    private CosmonautRepository cosmonautRepository;

    @Override
    public Flux<SpaceStatistics> getAll() {

        List<DatabaseRecord> cosmonautsFromDatabase = cosmonautRepository.findAll();
        Flux<SpaceStatistics> result = Flux.fromIterable(cosmonautsFromDatabase)
                .map(record ->
                        SpaceStatistics.builder()
                                .name(record.getName())
                                .spacrShip(record.getSpaceShip())
                                .from("PostgresDB")
                                .build());

        return result;

    }
}
