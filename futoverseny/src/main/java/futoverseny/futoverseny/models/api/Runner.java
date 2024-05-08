package futoverseny.futoverseny.models.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }
    public UUID id;
    public SexEnum sex;
    public Integer age;
    public String name;

    public Runner(SexEnum sex, Integer age, String name) {
        this.id = UUID.randomUUID();
        this.sex = sex;
        this.age = age;
        this.name = name;
    }

    public Runner(UUID id, SexEnum sex, Integer age, String name) {
        this.id = id;
        this.sex = sex;
        this.age = age;
        this.name = name;
    }
}
