package futoverseny.futoverseny.models.db;

import futoverseny.futoverseny.models.api.Result;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Entity
@Table(name="Results")
public class ResultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long resultId;
    private UUID runnerId;
    private UUID raceId;
    private Integer time;

    public ResultEntity() {
    }

    public ResultEntity(UUID runnerId, UUID raceId, Integer time) {
        this.time = time;
        this.raceId = raceId;
        this.runnerId = runnerId;
    }

    public ResultEntity(Long resultId, UUID runnerId, UUID raceId, Integer time) {
        this.resultId = resultId;
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.time = time;
    }

    public ResultEntity(Result result) {
        this.runnerId = result.getRunnerId();
        this.raceId = result.getRaceId();
        this.time = result.getTime();
    }

    public void Validate() throws HttpClientErrorException {
        if (runnerId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "runnerId is missing");
        }
        if (resultId == 0) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "resultId is missing");
        }
        if (raceId == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "raceId is missing");
        }
        if (time == null || time <= 0) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "time is missing or invalid");
        }
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
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
        return "ResultEntity{" +
                "resultId=" + resultId +
                ", runnerId=" + runnerId +
                ", raceId=" + raceId +
                ", time=" + time +
                '}';
    }
}
