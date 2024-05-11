package futoverseny.futoverseny.models.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

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

    public UUID id;
    public SexEnum sex;
    public Integer age;
    public String name;

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

    public void Validate() throws Exception {
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
        return;
    }
}
