package futoverseny.futoverseny.services;

import futoverseny.futoverseny.models.api.AverageTime;
import futoverseny.futoverseny.repository.RaceRepository;
import futoverseny.futoverseny.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.Race;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public ResponseEntity<Object> updateRace(Race race) throws HttpClientErrorException {
        race.Validate();

        java.util.Optional<Race> resp = raceRepository.findById(race.getId());
        if (resp.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"Race not found");
        }

        if (race.getName() == null || race.getName().isEmpty()) {
            // use existing name
            race.setName(resp.get().getName());
        }
        if (race.getDistance() == null || race.getDistance() <= 0) {
            // use existing distance
            race.setDistance(resp.get().getDistance());
        }
        raceRepository.save(race);

        return ResponseEntity.ok().build();
    }
}
