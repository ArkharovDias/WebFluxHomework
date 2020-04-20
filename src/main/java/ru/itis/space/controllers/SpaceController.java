package ru.itis.space.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import ru.itis.space.entires.SpaceStatistics;
import ru.itis.space.services.SpaceService;

@Controller
@RequestMapping("/space-service")
public class SpaceController {

    @Autowired
    private SpaceService spacedotaService;

    @GetMapping(value = "/cosmonauts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<SpaceStatistics> getAll() {
        return spacedotaService.getAll();
    }
}
