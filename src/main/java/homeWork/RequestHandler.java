package homeWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class RequestHandler {
    static OkHttpClient okHttpClient = new OkHttpClient();
    static ObjectMapper objectMapper = new ObjectMapper();

    public static String getCityID(String cityName) throws IOException {


        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", "nrMqQShGKf56Jwi3JspDBMAS0ssufrya")
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String jsonString = response.body().string();


        String cityID = objectMapper.readTree(jsonString).get(0).at("/Key").asText();

        return cityID;
    }

    public static String getForecastForDay(String cityID) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(cityID)
                .addQueryParameter("apikey", "nrMqQShGKf56Jwi3JspDBMAS0ssufrya")
                .build();

        Request request = new Request.Builder()
                .addHeader("Accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String jsonString = response.body().string();

        WhetherResponse whetherResponse = objectMapper.readValue(jsonString, WhetherResponse.class);

        String weatherDescription = whetherResponse.getHeadline().getText();

        int minF = whetherResponse.getDailyForecastsList().get(0).getTemperature().getMin().getValue();
        int maxF = whetherResponse.getDailyForecastsList().get(0).getTemperature().getMax().getValue();

        int minC = (int) (5f / 9 * (minF - 32));
        int maxC = (int) (5f / 9 * (maxF - 32));

        String weather = weatherDescription + "." + "\n" +"Min temperature = " + minC + "; " + "Max temperature = " + maxC + ".";
        return weather;

    }
}
