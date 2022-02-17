package homeWork8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Temperature {
    @JsonProperty("Minimum")
    private TemperatureValue min;
    @JsonProperty("Maximum")
    private TemperatureValue max;

    public TemperatureValue getMin() {
        return min;
    }

    public TemperatureValue getMax() {
        return max;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "min=" + min +
                ", max=" + max +
                '}';
    }
}
