package futoverseny.futoverseny.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Entity
@Table(name="Races")
public class Race {

    private String name;
    private Integer distance;
    @Id
    @Column(unique = true)
    private UUID id;

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

    public void Validate() throws HttpClientErrorException {
        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
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
