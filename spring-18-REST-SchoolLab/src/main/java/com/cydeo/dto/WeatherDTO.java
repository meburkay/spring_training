
package com.cydeo.dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "request",
    "location",
    "current"
})
@Generated("jsonschema2pojo")
public class WeatherDTO {

    @JsonProperty("request")
    private RequestDTO request;
    @JsonProperty("location")
    private LocationDTO location;
    @JsonProperty("current")
    private com.cydeo.dto.CurrentDTO currentDTO;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("request")
    public RequestDTO getRequest() {
        return request;
    }

    @JsonProperty("request")
    public void setRequest(RequestDTO request) {
        this.request = request;
    }

    @JsonProperty("location")
    public LocationDTO getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    @JsonProperty("current")
    public com.cydeo.dto.CurrentDTO getCurrent() {
        return currentDTO;
    }

    @JsonProperty("current")
    public void setCurrent(com.cydeo.dto.CurrentDTO currentDTO) {
        this.currentDTO = currentDTO;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
