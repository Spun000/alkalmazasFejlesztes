package futoverseny.futoverseny.models;

import futoverseny.futoverseny.models.db.ResultEntity;
import jakarta.persistence.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Races")
public class Race {

    private String name;
    private Integer distance;
    @Id
    @Column(name = "race_id", unique = true)
    private UUID id;

    @OneToMany(mappedBy = "raceId")
    private List<ResultEntity> results;

    public Race() {
    }

    public Race(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public Race(String name, Integer distance, UUID id) {
        this.name = name;
        this.distance = distance;
        this.id = id;
    }

    public void ValidateId() throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }
    }

    public void Validate() throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }
        if (name == null || name.isEmpty()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "name is missing or empty");
        }
        if (distance == null || distance <= 0) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "distance is missing or invalid");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Race{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", id=" + id +
                '}';
    }
}
