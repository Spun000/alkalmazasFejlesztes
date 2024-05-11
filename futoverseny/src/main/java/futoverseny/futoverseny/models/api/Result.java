package futoverseny.futoverseny.models.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

public class Result {
    public UUID runnerId;
    public UUID raceId;
    public Integer time;

    public Result() {
    }

    public Result(UUID runnerId, UUID raceId, Integer time) {
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.time = time;
    }

    public void Validate() throws Exception {
        if (runnerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "runnerId is missing");
        }
        if (raceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "raceId is missing");
        }
        if (time == null || time <= 0) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "time is missing or invalid");
        }
        return;
    }
}
