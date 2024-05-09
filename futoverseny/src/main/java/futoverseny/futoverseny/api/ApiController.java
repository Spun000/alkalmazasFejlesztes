package futoverseny.futoverseny.api;

import futoverseny.futoverseny.models.api.ErrorResponse;
import futoverseny.futoverseny.models.api.Runner;
import futoverseny.futoverseny.runner.RunnerService;
import futoverseny.futoverseny.race.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

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
    public ResponseEntity<List<Runner>> GetRunners() {
        return runnerService.getRunners();
    }

    @PostMapping(path = "addRunner")
    public ResponseEntity<Object> AddRunner(@RequestBody Runner runner) {
        System.out.println("AddRunner");
        try {
            return runnerService.addRunner(runner);
        }
        catch (HttpStatusCodeException e) {
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body(new ErrorResponse(e.getMessage()));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse(e.getMessage()));
        }

        return null;
    }

    @GetMapping(path = "getRaceRunners/{ID}")
    public ResponseEntity<List<Runner>> GetRaceRunners(@PathVariable(required = true) UUID ID) {
        return raceService.getRaceRunners(ID);
    }
}
