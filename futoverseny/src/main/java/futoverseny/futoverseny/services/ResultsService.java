package futoverseny.futoverseny.services;

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
    //runners.add(new Runner(Runner.SexEnum.MALE, 18, "John Runner"));
    //runners.add(new Runner(Runner.SexEnum.FEMALE, 18, "Jane Runner"));

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
}
