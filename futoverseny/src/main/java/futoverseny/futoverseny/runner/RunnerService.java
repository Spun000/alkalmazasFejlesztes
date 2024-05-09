package futoverseny.futoverseny.runner;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.api.Runner;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {

    List<Runner> runners = new ArrayList<Runner>();

    public ResponseEntity<List<Runner>> getRunners() {
        return ResponseEntity.ok(runners);
    }

    public ResponseEntity<Object> addRunner(Runner runner) throws Exception {
        runner.Validate();
        runners.add(runner);
        return ResponseEntity.ok().build();
    }
}
