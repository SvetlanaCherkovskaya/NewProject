package homeWork7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    @JsonProperty("Temperature")
    private Temperature temperature;

    public Temperature getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "temperature=" + temperature +
                '}';
    }
}
