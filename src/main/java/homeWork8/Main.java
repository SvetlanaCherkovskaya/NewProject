package homeWork8;


import java.io.IOException;

public class Main {
    public static void main(String[] args) {


        try (DbHendler dbHendler = new DbHendler()) {

            dbHendler.addDayWeather(DayWeather.makeDayWeather("Saint Petersburg",
                    RequestHandler.getForecastForDay(RequestHandler.
                            getCityID("Saint Petersburg"))));

            dbHendler.addDayWeather(DayWeather.makeDayWeather("Saint Petersburg",
                    RequestHandler.getForecastForDay(RequestHandler.
                            getCityID("Saint Petersburg"))));

            System.out.println(dbHendler.getAllDays());

            dbHendler.deleteDayWeather(5);
            dbHendler.deleteDayWeather(4);
            dbHendler.deleteDayWeather(3);
            dbHendler.deleteDayWeather(2);

            System.out.println(dbHendler.getAllDays());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
