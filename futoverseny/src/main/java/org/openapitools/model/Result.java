package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * Result
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-06T19:22:08.061271276+02:00[Europe/Budapest]", comments = "Generator version: 7.6.0-SNAPSHOT")
public class Result {

  private Integer runnerId;

  private Integer raceId;

  private Integer time;

  public Result() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public Result(Integer runnerId, Integer raceId, Integer time) {
    this.runnerId = runnerId;
    this.raceId = raceId;
    this.time = time;
  }

  public Result runnerId(Integer runnerId) {
    this.runnerId = runnerId;
    return this;
  }

  /**
   * Get runnerId
   * @return runnerId
  */
  @NotNull 
  @Schema(name = "runnerId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("runnerId")
  public Integer getRunnerId() {
    return runnerId;
  }

  public void setRunnerId(Integer runnerId) {
    this.runnerId = runnerId;
  }

  public Result raceId(Integer raceId) {
    this.raceId = raceId;
    return this;
  }

  /**
   * Get raceId
   * @return raceId
  */
  @NotNull 
  @Schema(name = "raceId", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("raceId")
  public Integer getRaceId() {
    return raceId;
  }

  public void setRaceId(Integer raceId) {
    this.raceId = raceId;
  }

  public Result time(Integer time) {
    this.time = time;
    return this;
  }

  /**
   * time in min
   * @return time
  */
  @NotNull 
  @Schema(name = "time", description = "time in min", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("time")
  public Integer getTime() {
    return time;
  }

  public void setTime(Integer time) {
    this.time = time;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Result result = (Result) o;
    return Objects.equals(this.runnerId, result.runnerId) &&
        Objects.equals(this.raceId, result.raceId) &&
        Objects.equals(this.time, result.time);
  }

  @Override
  public int hashCode() {
    return Objects.hash(runnerId, raceId, time);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Result {\n");
    sb.append("    runnerId: ").append(toIndentedString(runnerId)).append("\n");
    sb.append("    raceId: ").append(toIndentedString(raceId)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
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

