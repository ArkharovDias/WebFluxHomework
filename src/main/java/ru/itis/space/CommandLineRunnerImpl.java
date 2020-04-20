package ru.itis.space;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import ru.itis.space.entires.AstrosApiResponse;
import ru.itis.space.entires.models.DatabaseRecord;
import ru.itis.space.repositories.CosmonautRepository;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Value("${space.api.url}")
    private String url;

    @Autowired
    private CosmonautRepository cosmonautRepository;

    @Override
    public void run(String... args) throws Exception {

        List<String> names = Arrays.asList("Ivan", "Ruslan", "Dmitriy", "Petya", "Slava", "Vova");
        List<String> ships = Arrays.asList("Appolon-1","Appolon-2","Appolon-3","Appolon-4","Appolon-5","Appolon-6");

        for (int i = 0; i < names.size(); i++) {
            DatabaseRecord cosmonaut = DatabaseRecord.builder()
                    .name(names.get(i))
                    .spaceShip(ships.get(i))
                    .build();

            cosmonautRepository.save(cosmonaut);
        }

    }
}
