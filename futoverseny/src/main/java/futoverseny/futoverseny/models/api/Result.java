package futoverseny.futoverseny.models.api;

import futoverseny.futoverseny.models.db.ResultEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

public class Result {

    private UUID runnerId;
    private UUID raceId;
    private Integer time;

    public Result() {
    }

    public Result(UUID runnerId, UUID raceId, Integer time) {
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.time = time;
    }

    public Result(ResultEntity responseEntity) {
        this.runnerId = responseEntity.getRunnerId();
        this.raceId = responseEntity.getRaceId();
        this.time = responseEntity.getTime();
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

    public UUID getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(UUID runnerId) {
        this.runnerId = runnerId;
    }

    public UUID getRaceId() {
        return raceId;
    }

    public void setRaceId(UUID raceId) {
        this.raceId = raceId;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Result{" +
                "runnerId=" + runnerId +
                ", raceId=" + raceId +
                ", time=" + time +
                '}';
    }
}
