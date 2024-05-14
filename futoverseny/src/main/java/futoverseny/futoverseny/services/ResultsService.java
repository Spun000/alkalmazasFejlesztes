package futoverseny.futoverseny.services;

import futoverseny.futoverseny.models.Race;
import futoverseny.futoverseny.models.api.Result;
import futoverseny.futoverseny.models.api.AverageTime;
import futoverseny.futoverseny.models.db.ResultEntity;
import futoverseny.futoverseny.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResultsService {
    public  final ResultRepository resultRepository;

    @Autowired
    public ResultsService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public ResponseEntity<Object> getRaceRunners(UUID id) throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }

        List<ResultEntity> resultEntities = findByRaceId(id);
        List<Result> results = new ArrayList<Result>();
        for (ResultEntity resultEntity : resultEntities) {
            results.add(new Result(resultEntity));
        }

        return ResponseEntity.ok(results);
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
