package futoverseny.futoverseny.runner;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.api.Runner;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {

    public ResponseEntity<List<Runner>> getRunners() {
        List<Runner> runners = new ArrayList<Runner>();
        runners.add(new Runner(Runner.SexEnum.MALE, 18, "John Runner"));
        runners.add(new Runner(Runner.SexEnum.FEMALE, 18, "Jane Runner"));
        return ResponseEntity.ok(runners);
    }
}
