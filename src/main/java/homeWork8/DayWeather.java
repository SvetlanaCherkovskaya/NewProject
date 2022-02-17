package homeWork8;

public class DayWeather {

    private final String nameCity;
    private final String date;
    private final double tempMin;
    private final double tempMax;

    public DayWeather(String nameCity, String date, double tempMin, double tempMax) {
        this.nameCity = nameCity;
        this.date = date;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public String getNameCity() {
        return nameCity;
    }

    public String getDate() {
        return date;
    }

    public double getTempMin() {
        return tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    @Override
    public String toString() {
        return "DayWeather{" +
                "nameCity='" + nameCity + '\'' +
                ", date='" + date + '\'' +
                ", tempMin='" + tempMin + '\'' +
                ", tempMax='" + tempMax + '\'' +
                '}';
    }

    public static DayWeather makeDayWeather(String cityName, WhetherResponse whetherResponse) {

        String date = whetherResponse.getDailyForecastsList().get(0).getDate();

        double minF = whetherResponse.getDailyForecastsList().get(0).getTemperature().getMin().getValue();
        double maxF = whetherResponse.getDailyForecastsList().get(0).getTemperature().getMax().getValue();

        double tempMin = (int) (5f / 9 * (minF - 32));
        double tempMax = (int) (5f / 9 * (maxF - 32));


        return new DayWeather(cityName, date, tempMin, tempMax);
    }
}
