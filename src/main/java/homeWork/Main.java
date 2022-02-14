package homeWork;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println(RequestHandler.getForecastForDay(RequestHandler.getCityID("Saint Petersburg")));
    }
}
