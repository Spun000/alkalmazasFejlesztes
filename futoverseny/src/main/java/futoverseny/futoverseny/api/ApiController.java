package futoverseny.futoverseny.api;

import futoverseny.futoverseny.models.api.Runner;
import futoverseny.futoverseny.runner.RunnerService;
import futoverseny.futoverseny.race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1")
public class ApiController {
    private final RunnerService runnerService;
    private final RaceService raceService;

    @Autowired
    public ApiController(RunnerService runnerService, RaceService raceService) {
        this.runnerService = runnerService;
        this.raceService = raceService;
    }

    @GetMapping(path = "getRunners")
    public ResponseEntity<List<Runner>> getRunners() {
        return runnerService.getRunners();
    }

    @GetMapping(path = "getRaceRunners/{ID}")
    public ResponseEntity<List<Runner>> getRaceRunners(@PathVariable(required = true) UUID ID) {
        return raceService.getRaceRunners(ID);
    }
}
