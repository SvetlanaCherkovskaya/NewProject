package homeWork7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WhetherResponse {

    @JsonProperty("Headline")
    private HeadLine headline;

    @JsonProperty("DailyForecasts")
    private List<DailyForecasts> dailyForecastsList;

    public HeadLine getHeadline() {
        return headline;
    }

    public List<DailyForecasts> getDailyForecastsList() {
        return dailyForecastsList;
    }

    @Override
    public String toString() {
        return "WhetherResponse{" +
                "headline='" + headline + '\'' +
                ", dailyForecastsList=" + dailyForecastsList +
                '}';
    }
}
