package futoverseny.futoverseny.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Entity
@Table(name="Results")
public class Result {
    @Id
    public UUID runnerId;
    @Id
    public UUID raceId;
    public Integer time;

    public Result() {
    }

    public Result(UUID runnerId, UUID raceId, Integer time) {
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.time = time;
    }

    public void Validate() throws HttpClientErrorException {
        if (runnerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "runnerId is missing");
        }
        if (raceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "raceId is missing");
        }
        if (time == null || time <= 0) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "time is missing or invalid");
        }
    }
}
