package homeWork8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyForecasts {
    @JsonProperty("Temperature")
    private Temperature temperature;

    @JsonProperty("Date")
    private String date;

    public Temperature getTemperature() {
        return temperature;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DailyForecasts{" +
                "temperature=" + temperature +
                ", date=" + date +
                '}';
    }
}
