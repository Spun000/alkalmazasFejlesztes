package futoverseny.futoverseny.race;

import futoverseny.futoverseny.models.api.AverageTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import futoverseny.futoverseny.models.api.Race;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class RaceService {
    public ResponseEntity<Object>  updateRace(Race race) throws Exception {
        race.Validate();

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

        /*if (runners.isEmpty())
        {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND,"No runner found"); // TODO
        }*/
        /*if (false)
        {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR,"Something bad happened); // TODO
        }*/
        AverageTime averageTime = new AverageTime();
        return ResponseEntity.ok(averageTime);
    }
}
