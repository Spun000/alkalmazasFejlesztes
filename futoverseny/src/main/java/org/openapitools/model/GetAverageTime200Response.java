package org.openapitools.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * GetAverageTime200Response
 */

@JsonTypeName("GetAverageTime_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-05-06T19:22:08.061271276+02:00[Europe/Budapest]", comments = "Generator version: 7.6.0-SNAPSHOT")
public class GetAverageTime200Response {

  private Integer averageTime;

  public GetAverageTime200Response averageTime(Integer averageTime) {
    this.averageTime = averageTime;
    return this;
  }

  /**
   * average time in min
   * @return averageTime
  */
  
  @Schema(name = "averageTime", description = "average time in min", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("averageTime")
  public Integer getAverageTime() {
    return averageTime;
  }

  public void setAverageTime(Integer averageTime) {
    this.averageTime = averageTime;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetAverageTime200Response getAverageTime200Response = (GetAverageTime200Response) o;
    return Objects.equals(this.averageTime, getAverageTime200Response.averageTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(averageTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetAverageTime200Response {\n");
    sb.append("    averageTime: ").append(toIndentedString(averageTime)).append("\n");
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

