package homeWork;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TemperatureValue {
    @JsonProperty("Value")
    private int value;

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "TemperatureValue{" +
                "value=" + value +
                '}';
    }
}
