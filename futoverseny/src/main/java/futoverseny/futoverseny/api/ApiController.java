package futoverseny.futoverseny.api;

import futoverseny.futoverseny.models.api.ErrorResponse;
import futoverseny.futoverseny.models.Runner;
import futoverseny.futoverseny.models.api.Result;
import futoverseny.futoverseny.models.Race;
import futoverseny.futoverseny.services.RunnerService;
import futoverseny.futoverseny.services.ResultsService;
import futoverseny.futoverseny.services.RaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1")
public class ApiController {
    private final RunnerService runnerService;
    private final RaceService raceService;
    private final ResultsService resultsService;

    @Autowired
    public ApiController(RunnerService runnerService, RaceService raceService, ResultsService resultsService) {
        this.runnerService = runnerService;
        this.raceService = raceService;
        this.resultsService = resultsService;
    }

    @GetMapping(path = "getRunners")
    public ResponseEntity<Object> GetRunners() {
        try {
            return runnerService.getRunners();
        } catch (Exception e) {
            return HandleException(e);
        }
    }

    @PostMapping(path = "addRunner")
    public ResponseEntity<Object> AddRunner(@RequestBody(required = true) Runner runner) {
        try {

            return runnerService.addRunner(runner);
        } catch (Exception e) {

            return HandleException(e);
        }
    }

    @GetMapping(path = "getRaceRunners/{ID}")
    public ResponseEntity<Object> GetRaceRunners(@PathVariable(required = true) UUID ID) {
        try {

            return resultsService.getRaceRunners(ID);
        } catch (Exception e) {

            return HandleException(e);
        }
    }

    @PostMapping(path = "updateRace")
    public ResponseEntity<Object> UpdateRace(@RequestBody(required = true) Race race) {
        try {

            return raceService.updateRace(race);
        } catch (Exception e) {

            return HandleException(e);
        }
    }

    @PostMapping(path = "addResult")
    public ResponseEntity<Object> AddResult(@RequestBody(required = true) Result result) {
        try {

            return resultsService.addResult(result);
        } catch (Exception e) {

            return HandleException(e);
        }
    }

    @GetMapping(path = "getAverageTime/{VERSENYID}")
    public ResponseEntity<Object> GetAverageTime(@PathVariable(required = true) UUID VERSENYID) {
        try {

            return resultsService.getAverageTime(VERSENYID);
        } catch (Exception e) {

            return HandleException(e);
        }
    }

    public static ResponseEntity<Object> HandleException(Exception e) {
            if (e instanceof HttpStatusCodeException) {
                return switch (((HttpStatusCodeException) e).getStatusCode()) {
                    case HttpStatus.BAD_REQUEST -> ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(new ErrorResponse(e.getMessage()));
                    case HttpStatus.NOT_FOUND -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body(new ErrorResponse(e.getMessage()));
                    case HttpStatus.CONFLICT -> ResponseEntity.status(HttpStatus.CONFLICT)
                            .body(new ErrorResponse(e.getMessage()));
                    default -> ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                .body(new ErrorResponse(e.getMessage()));
                };
            }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(e.getMessage()));
    }
}
