package futoverseny.futoverseny.models.api;

import java.util.UUID;

public class Race {

    public String name;
    public Integer distance;
    public UUID id;

    public Race() {
        this.id = UUID.randomUUID();
    }

    public Race(String name, Integer distance) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.distance = distance;
    }

    public Race(String name, Integer distance, UUID id) {
        this.name = name;
        this.distance = distance;
        this.id = id;
    }
}
