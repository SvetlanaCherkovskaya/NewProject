package homeWork8;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WhetherResponse {

    @JsonProperty("DailyForecasts")

    private List<DailyForecasts> dailyForecastsList;

    public List<DailyForecasts> getDailyForecastsList() {
        return dailyForecastsList;
    }


}
