package futoverseny.futoverseny.results;

import futoverseny.futoverseny.models.api.Result;
import futoverseny.futoverseny.models.api.Runner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ResultsService {
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
}
