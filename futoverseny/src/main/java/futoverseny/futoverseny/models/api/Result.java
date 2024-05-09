package futoverseny.futoverseny.models.api;

import java.util.UUID;

public class Result {
    public UUID runnerId;
    public UUID raceId;
    public Integer time;

    public Result() {
        this.runnerId = UUID.randomUUID();
        this.raceId = UUID.randomUUID();
    }

    public Result(Integer time) {
        this.runnerId = UUID.randomUUID();
        this.raceId = UUID.randomUUID();
        this.time = time;
    }

    public Result(UUID runnerId, UUID raceId, Integer time) {
        this.runnerId = runnerId;
        this.raceId = raceId;
        this.time = time;
    }
}
