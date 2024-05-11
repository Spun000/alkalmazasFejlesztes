package futoverseny.futoverseny.models.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

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

    public void Validate() throws Exception {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }
        if (distance == null || distance <= 0) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "distance is missing or invalid");
        }
        if (name == null || name.isEmpty()) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "name is missing");
        }
        return;
    }
}
