package futoverseny.futoverseny.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Entity
@Table(name="Runners")
public class Runner {
    public enum SexEnum {
        MALE("male"),
        FEMALE("female");

        final private String value;

        SexEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @JsonCreator
        public static SexEnum fromValue(String value) {
            for(SexEnum v : SexEnum.values()) {
                if (v.value.equals(value)) {
                    return v;
                }
            }
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "Unexpected value '" + value + "'");
        }
    }

    @Id
    @Column(unique = true)
    private UUID id;
    private SexEnum sex;
    private Integer age;
    private String name;

    public Runner() {
        System.out.println("const 0");
        this.id = UUID.randomUUID();
    }

    public Runner(SexEnum sex, Integer age, String name) {
        System.out.println("const 3");
        this.id = UUID.randomUUID();
        this.sex = sex;
        this.age = age;
        this.name = name;
    }

    public Runner(UUID id, SexEnum sex, Integer age, String name) {
        System.out.println("const 4");
        this.id = id;
        if (this.id == null) {
            this.id = UUID.randomUUID();
        }
        this.sex = sex;
        this.age = age;
        this.name = name;
    }

    public void Validate() throws HttpClientErrorException {
        if (id == null) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "id is missing");
        }
        if (sex == null) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "sex is missing");
        }
        if (age == null || age <= 0) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "age is missing or invalid");
        }
        if (name == null || name.isEmpty()) {
            throw new  HttpClientErrorException(HttpStatus.BAD_REQUEST, "name is missing");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Runner{" +
                "id=" + id +
                ", sex=" + sex +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
