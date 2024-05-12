package futoverseny.futoverseny.services;

import futoverseny.futoverseny.models.Result;
import futoverseny.futoverseny.models.Runner;
import futoverseny.futoverseny.models.api.AverageTime;
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

    public ResponseEntity<Object> getRaceRunners(UUID id) throws Exception {
        System.out.println("uuid: " + id);
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }
        List<Runner> runners = new ArrayList<Runner>();
        runners.add(new Runner(Runner.SexEnum.MALE, 18, "John Runner"));
        runners.add(new Runner(Runner.SexEnum.FEMALE, 18, "Jane Runner"));
        /*if (runners.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No runner found"); // TODO
        }*/
        /*if (false)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        return ResponseEntity.ok(runners);
    }

    public ResponseEntity<Object> addResult(Result result) throws Exception {
        result.Validate();
        /*if (runners.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No runner found"); // TODO
        }*/
        /*if (false)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Object>  getAverageTime(UUID id) throws Exception {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("runnerId")
                .withIgnorePaths("time");
                //.withMatcher("raceId", );
        Result exampleResult = new Result(id, UUID.randomUUID(),1);
        Example<Result> example = Example.of(exampleResult,matcher);
        List<Result> results = new ArrayList<Result>();
        results = resultRepository.findAll(example);
        if (results.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No results found");
        }
        /*if (false)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        int summTime = 0;
        for(Result r : results) {
            summTime += r.time;
        }
        int avgTime = summTime / results.size();
        return ResponseEntity.ok(new AverageTime(avgTime));
    }
}
