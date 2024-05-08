package futoverseny.futoverseny.race;

import futoverseny.futoverseny.models.api.Runner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RaceService {

    public ResponseEntity<List<Runner>>  getRaceRunners(@RequestParam UUID id) {
        System.out.println("uuid: " + id);
        List<Runner> runners = new ArrayList<Runner>();
        runners.add(new Runner(Runner.SexEnum.MALE, 18, "John Runner"));
        runners.add(new Runner(Runner.SexEnum.FEMALE, 18, "Jane Runner"));
        return ResponseEntity.ok(runners);
    }
}
