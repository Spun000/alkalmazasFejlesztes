package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Runner
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-06T19:22:08.061271276+02:00[Europe/Budapest]", comments = "Generator version: 7.6.0-SNAPSHOT")
public class Runner {

  private Integer id;

  /**
   * Gets or Sets sex
   */
  public enum SexEnum {
    MALE("male"),
    
    FEMALE("female");

    private String value;

    SexEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static SexEnum fromValue(String value) {
      for (SexEnum b : SexEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  private SexEnum sex;

  private Integer age;

  private String name;

  public Runner() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Runner(Integer id, SexEnum sex, Integer age, String name) {
    this.id = id;
    this.sex = sex;
    this.age = age;
    this.name = name;
  }

  public Runner id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Runner sex(SexEnum sex) {
    this.sex = sex;
    return this;
  }

  /**
   * Get sex
   * @return sex
  */
  @NotNull 
  @Schema(name = "sex", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sex")
  public SexEnum getSex() {
    return sex;
  }

  public void setSex(SexEnum sex) {
    this.sex = sex;
  }

  public Runner age(Integer age) {
    this.age = age;
    return this;
  }

  /**
   * Get age
   * @return age
  */
  @NotNull 
  @Schema(name = "age", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("age")
  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Runner name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Runner runner = (Runner) o;
    return Objects.equals(this.id, runner.id) &&
        Objects.equals(this.sex, runner.sex) &&
        Objects.equals(this.age, runner.age) &&
        Objects.equals(this.name, runner.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sex, age, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Runner {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sex: ").append(toIndentedString(sex)).append("\n");
    sb.append("    age: ").append(toIndentedString(age)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

