package futoverseny.futoverseny.services;

import futoverseny.futoverseny.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.Runner;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunnerService {
    private final RunnerRepository runnerRepository;


    @Autowired
    public RunnerService(RunnerRepository runnerRepository) {
        this.runnerRepository = runnerRepository;
    }

    public ResponseEntity<Object> getRunners() throws Exception {
        List<Runner> runners = new ArrayList<Runner>();
        runners = runnerRepository.findAll();
        return ResponseEntity.ok(runners);
    }

    public ResponseEntity<Object> addRunner(Runner runner) throws Exception {
        runner.Validate();
        runnerRepository.save(runner);
        return ResponseEntity.ok().build();
    }
}
