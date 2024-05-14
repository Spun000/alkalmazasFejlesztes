package futoverseny.futoverseny.services;

import futoverseny.futoverseny.models.Race;
import futoverseny.futoverseny.models.Runner;
import futoverseny.futoverseny.models.api.RaceRunner;
import futoverseny.futoverseny.models.api.Result;
import futoverseny.futoverseny.models.api.AverageTime;
import futoverseny.futoverseny.models.db.ResultEntity;
import futoverseny.futoverseny.repository.ResultRepository;
import futoverseny.futoverseny.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResultsService {
    private  final ResultRepository resultRepository;
    private final RunnerRepository runnerRepository;

    @Autowired
    public ResultsService(ResultRepository resultRepository, RunnerRepository runnerRepository) {
        this.resultRepository = resultRepository;
        this.runnerRepository = runnerRepository;
    }

    public ResponseEntity<Object> getRaceRunners(UUID id) throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }

        List<ResultEntity> resultEntities = findByRaceId(id);
        List<RaceRunner> raceRunners = new ArrayList<RaceRunner>();
        for (ResultEntity resultEntity : resultEntities) {
            Optional<Runner> runner = runnerRepository.findById(resultEntity.getRunnerId());
            if (runner.isEmpty()) {
                throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "Runner not found");
            }
            raceRunners.add(new RaceRunner(resultEntity.getTime(),runner.get().getName()));
        }

        raceRunners.sort(new Comparator<RaceRunner>() {
            @Override
            public int compare(RaceRunner o1, RaceRunner o2) {
                return o1.getTime() - o2.getTime();
            }
        });
        return ResponseEntity.ok(raceRunners);
    }

    public ResponseEntity<Object> addResult(Result result) throws HttpClientErrorException {
        result.Validate();
        if (resultExists(result.getRaceId(),result.getRunnerId())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "result already exists");
        }
        resultRepository.save(new ResultEntity(result));

        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object>  getAverageTime(UUID id) throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }

        List<ResultEntity> resultEntities = findByRaceId(id);
        int sumTime = 0;
        for(ResultEntity r : resultEntities) {
            sumTime += r.getTime();
        }
        int avgTime = (sumTime / resultEntities.size());

        return ResponseEntity.ok(new AverageTime(avgTime));
    }

    private List<ResultEntity> findByRaceId(UUID id) throws HttpClientErrorException {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("runnerId")
                .withIgnorePaths("time")
                .withIgnorePaths("resultId");
        ResultEntity exampleResult = new ResultEntity();
        exampleResult.setRaceId(id);
        Example<ResultEntity> example = Example.of(exampleResult,matcher);

        List<ResultEntity> resultEntities = new ArrayList<ResultEntity>();
        resultEntities = resultRepository.findAll(example);
        if (resultEntities.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No results found");
        }

        return resultEntities;
    }

    private boolean resultExists(UUID raceId, UUID runnerId) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("time")
                .withIgnorePaths("resultId");
        ResultEntity exampleResult = new ResultEntity();
        exampleResult.setRaceId(raceId);
        exampleResult.setRunnerId(runnerId);
        Example<ResultEntity> example = Example.of(exampleResult,matcher);

        java.util.Optional<ResultEntity> resp = resultRepository.findOne(example);

        return resp.isPresent();
    }
}
