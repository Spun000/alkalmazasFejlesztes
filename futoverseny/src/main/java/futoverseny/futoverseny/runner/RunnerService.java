package futoverseny.futoverseny.runner;

import com.sun.jdi.InternalException;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.api.Runner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {

    List<Runner> runners = new ArrayList<Runner>();

    public ResponseEntity<Object> getRunners() throws Exception {
        if (runners.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No runner found");
        }
        /*if (false)
        {
              throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        return ResponseEntity.ok(runners);
    }

    public ResponseEntity<Object> addRunner(Runner runner) throws Exception {
        runner.Validate();
        runners.add(runner);
        /*if (false)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        return ResponseEntity.ok().build();
    }
}
